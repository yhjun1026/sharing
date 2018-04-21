<!-- 积分流水查询 -->
<template>
  <div class="deal-account-page ffan-style">
    <div class="crumbs">
      <el-breadcrumb separator="">
        <el-breadcrumb-item normal>会员维护与应用</el-breadcrumb-item>
        <el-breadcrumb-item normal>礼品管理</el-breadcrumb-item>
        <el-breadcrumb-item>兑退记录</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content-wrap">
      <div class="search-box">
        <el-row type="flex" justify="end" align="middle">
          <el-button type="text" @click="showMoreParams = !showMoreParams">
            {{ showMoreParams ? '收起' : '更多查询'}}
            &nbsp;<i class="el-icon-arrow-down"></i>
          </el-button>
        </el-row>
        <div>
        </div>
        <el-form :inline="true" :model="searchForm" class="searchBox"
                 label-width="90px" ref="searchForm" :rules="rules">
          <el-form-item label="礼品编号:" prop="giftCode" label-width="75px">
            <el-input size="small" class="search-by-shop item-el-w" placeholder="请输入礼品编号"
                      v-model="searchForm.giftCode" style="width:200px"
                      type="text">
            </el-input>
          </el-form-item>
          <el-form-item label="会员ID:" prop="memberId">
            <el-input size="small" class="search-by-shop item-el-w" placeholder="请输入会员ID"
                      v-model="searchForm.memberId" style="width:200px"
                      type="text">
            </el-input>
          </el-form-item>
          <el-form-item label="手机号:" prop="memberPhoneNo">
            <el-input size="small" class="search-by-shop item-el-w" placeholder="请输入11位手机号"
                      v-model="searchForm.memberPhoneNo" style="width:200px"
                      type="text">
            </el-input>
          </el-form-item>
          <el-form-item label="所属广场:" prop="orgCode" label-width="75px">
            <el-cascader class="item-el-w"
                         :options="orgs"
                         :change-on-select="true"
                         :clearable="true"
                         size="small" v-model="searchForm.selectOrg" placeholder="不限"
                         @change="changeSelectedOrg"
                         :props="orgProps"
                         ref="selectOrgEl"
            ></el-cascader>
          </el-form-item>
          <el-form-item label="礼品名称:" prop="giftName" >
            <el-input size="small" class="search-by-shop item-el-w" placeholder="请输入礼品名称" v-model="searchForm.giftName"
                      type="text">
            </el-input>
          </el-form-item>
          <el-form-item label="操作类型:" prop="operation">
            <el-select size="small" v-model="searchForm.operation"
                       placeholder="不限" class="item-el-w">
              <el-option v-for="(op,index) in operation" :key="index"
                         :label="op.name" :value="op.code"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="兑换方式:" prop="exchangeMode" label-width="75px">
            <el-select size="small" v-model="searchForm.exchangeMode" placeholder="不限" style="width:200px;">
              <el-option :label="item.text" :value="item.code" v-for="(item, index) in exchangeCond"
                         :key="index"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="操作人:" prop="operatorName">
            <el-input size="small" class="search-by-shop item-el-w" placeholder="请输入操作人" v-model="searchForm.operatorName" style="width:200px"
                      type="text">
            </el-input>
          </el-form-item>
          <br />

          <el-form-item  v-if="showMoreParams"  label="积分价格:" label-width="75px">
            <el-form-item prop="minPoint">
              <el-input size="small" class="search-by-amount" v-model="searchForm.minPoint"
                        type="text" style="width:134px">
              </el-input>
            </el-form-item>
            <template>
              <span>-</span>
            </template>
            <el-form-item prop="maxPoint">
              <el-input  size="small" class="search-by-amount" v-model="searchForm.maxPoint"
                         type="text" style="width:134px" >
              </el-input>
            </el-form-item>
          </el-form-item>

          <el-form-item  v-if="showMoreParams" label="创建时间:" prop="date">
            <el-date-picker size="small" type="daterange"
                            placeholder="选择日期" :editable="false"
                            v-model="date" style="width:250px;"
                            @change="changeDate"
                            format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
          <el-form-item label="备注:" v-if="showMoreParams" label-width="66px" prop="remark">
            <el-input size="small" class="search-by-shop item-el-w" placeholder="请输入备注" v-model="searchForm.remark" style="width:200px"
                      type="text">
            </el-input>
          </el-form-item>

          <div style="text-align:center;">
            <el-button type="primary"
                       @click="checkAndSearch('searchForm')" :loading="searching">
              查询
            </el-button>
            <el-button type="primary" :plain="true"
                       @click="resetForm" :loading="searching">
              重置
            </el-button>
          </div>
        </el-form>
      </div>
      <div class="top-pagination">
        <el-pagination
          @current-change="changePage"
          @size-change="changeSize"
          :current-page="searchForm.pageIndex"
          :page-size="searchForm.pageSize"
          :page-sizes="[10, 20, 30]"
          layout="total, prev, pager, next, sizes,jumper"
          :total="totalCount">
        </el-pagination>
      </div>
      <el-table ref="resultList" :data="resultList" stripe>
        <el-table-column prop="operationTime" label="操作时间"
                         width="170" align="center">
          <template scope="scope">{{scope.row.operationTime | formatDateTime}}</template>
        </el-table-column>
        <el-table-column prop="operatorName" label="操作人"
                         width="160" align="center"></el-table-column>
        <el-table-column prop="giftCode" label="礼品编号"
                         width="180" align="center">
        </el-table-column>
        <el-table-column prop="giftName" label="礼品名称"
                         min-width="160" align="center"></el-table-column>
        <el-table-column  prop="memberId" label="会员ID"
                         width="180" align="center">
          <template scope="scope"><a href="#" @click.stop.prevent="gotoMemberDetail(scope.row.memberId)">{{scope.row.memberId || "暂无会员ID"}}</a></template>
        </el-table-column>

        <el-table-column prop="memberPhoneNo" label="手机号"
                         width="160" align="center">
          <template scope="scope"><a href="#" @click.stop.prevent="gotoMemberDetail(scope.row.memberId)">{{scope.row.memberPhoneNo || "无手机号"}}</a></template>
        </el-table-column>
        <el-table-column prop="orgName" label="所属广场"
                         min-width="160" align="center"></el-table-column>
        <el-table-column prop="operation" label="操作类型"
                         width="160" align="center"></el-table-column>
        <el-table-column prop="quantity" label="数量"
                         width="160" align="right">
          <template scope="scope">
            {{ scope.row.quantity | commafy }}
          </template>
        </el-table-column>
        <el-table-column prop="exchangeMode" label="兑换方式"
                         width="160" align="center">
          <template scope="scope">{{scope.row.exchangeMode === "GIVE"?"赠送":"积分兑换"}}</template>
        </el-table-column>

        <el-table-column prop="remark" label="备注"
                         width="160" align="center" fixed="right">
          <template scope="scope"><span :title="scope.row.remark">{{scope.row.remark|getRemarkText}}</span></template>
        </el-table-column>
      </el-table>
      <div class="bottom-pagination">
        <el-pagination
          @current-change="changePage"
          @size-change="changeSize"
          :current-page="searchForm.pageIndex"
          :page-size="searchForm.pageSize"
          :page-sizes="[10, 20, 30]"
          layout="total, prev, pager, next, sizes,jumper"
          :total="totalCount">
        </el-pagination>
      </div>
    </div>
    <qf-sailfooter></qf-sailfooter>
  </div>
</template>

<script>
  import store from '@/store';
  import filter from '@/filters';

  export default {
    components: {

    },
    data: () => {
      return {
        showMoreParams: false,
        orgProps: {
          value: 'code',
          label: 'name',
          children: 'orgs'
        },
        searchForm: {
          //兑换方式
          "exchangeMode": "",
          //礼品编号
          "giftCode": "",
          //礼品名称
          "giftName": "",
          //
          "maxPoint": "",
          "maxTime": "",
          //会员id
          "memberId": "",
          //会员手机号
          "memberPhoneNo": "",
          "minPoint": "",
          "minTime": "",
          //兑换方式
          "operation": "",
          //兑换人/操作人
          "operatorName": "",
          //广场编号
          "orgCode": "",
          "pageIndex": 0,
          "pageSize": 10,
          "remark": ""
        },
        resultList: [],
        exchangeCond: [{
          code: "EXCHANGE",
          text: "积分兑换"
        }, {
          code: "GIVE",
          text: "赠送"
        }],
        operation: [
          {
            code: "0",
            name: "兑换"
          },
          {
            code: "1",
            name: "退货"
          }
        ],
        orgs: [],
        date: "",
        totalCount: 0,
        searching: false,
        rules: {
          memberId: {pattern: /^\d{17}$/, message: '请输入17位会员ID'},
          remark: {pattern:/^(\w|[\u4e00-\u9fa5]){0,100}$/,message:"最多只能输入100个字符"},
          /*giftCode: {pattern: /^\d+$/, message: '请输入礼品编号'},*/
          memberPhoneNo: {type: 'string', pattern: /^1[345678]\d{9}$/, message: '请输入正确手机号', trigger: 'blur,change'},
          minPoint: {require: false, pattern:  /^(?:0|[1-9]{1}\d{0,5})$/, message: '请输入0~999999之间的整数'},
          maxPoint: {require: false, pattern:  /^(?:0|[1-9]{1}\d{0,5})$/, message: '请输入0~999999之间的整数'}
        }
      }
    },
    methods: {
        gotoMemberDetail(id){
            this.$router.push({
              name: "memberDetail",
              query: {
                memberCode: id,
                drainageType: ''
              }
            })
        },
      changeSize(newSize) {
        //this.searchForm.pageSize = newSize;
        this.getList({
          pageSize:newSize
        });
      },
      changePage(newPage) {
        if(this.searchForm.pageIndex === newPage){
            return;
        }
        this.getList({
          pageIndex:newPage
        });
      },
      changeDate(date) {
        const values = date.split(' - ');
        this.searchForm.minTime = +new Date(values[0]+" 00:00:00");
        this.searchForm.maxTime = +new Date(values[1]+" 24:00:00");
      },
      resetForm() {
        this.$refs['searchForm'].resetFields();
        this.date = "";
        this.searchForm.minPoint = "";
        this.searchForm.maxPoint = "";
        this.searchForm.selectOrg = "";
        this.$refs["selectOrgEl"].handlePick([],true);
      },
      checkAndSearch(formName){
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.search();
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      search() {
        this.searchForm.pageIndex = 1;
        this.getList();
      },
      getList(params) {
        this.searching = true;
        let searchParams = filter.dealParams(this.searchForm);
        Object.assign(searchParams,params);
        //console.log("test");
        filter.fetch([{
          url: '/sail/gift/orders/exchange/orders/search',
          params: searchParams,
          method: "post"
        }
       /* ,
          {
            url: '/sail/member/scopes',
            params: {
              type: 2
            }
          }*/
        ]).then(response => {
//          let [searchData, scopes] = response;
          let [searchData] = response;
          //searchData = this.mockData();

          if (searchData.status === '0000') {
            this.resultList = searchData.data;
            this.totalCount = searchData._metadata.totalCount;
            this.searchForm.pageSize = searchData._metadata.pageSize;
            this.searchForm.pageIndex = searchData._metadata.pageIndex;
          }
         /* if (scopes.status === '0000') {
            this.orgs = scopes.data;
            if (this.orgs.length = 1) {
              this.searchForm.orgCode = this.orgs[0].orgCode;
            }
          }*/
          this.searching = false;
        });
      },
      initSearchParams(){
        this.axios.all([
          this.axios.get('/sail/merchant/roles/plazaTypeRole/orgs/tree')
          /* ,
           this.axios.get('/sail/member/getDictionary', {
           params: { dictionary: 'certificate' }
           })*/
        ]).then(this.axios.spread((orgs) => {
            if(orgs.status == '0000') {
              //1 scopes
              this.orgs = this.formattedOrgs([orgs.data]);
            }
          })
        );
      },
      formattedOrgs(orgs) {
        if (!orgs) return [];
        this.resetOrgs(orgs);
        return orgs;
      },
      resetOrgs(orgs) {
        orgs.forEach(v => {
          if (v.orgs && v.orgs.length == 0) {
            v.orgs = null;
          }
          else {
            this.resetOrgs(v.orgs);
          }
        })
      },
      changeSelectedOrg(value) {
        if (value.length == 0) this.selectOrgCode = '';
        this.searchForm.orgCode = value[value.length - 1];
        this.selectShops = [];
        this.searchForm.shopId = '';
        this.axios.get('/sail/merchant/roles/storeTypeRole/orgs', {
          params: {orgCode: this.searchForm.orgCode}
        }).then(response => {
          const {status, message, data} = response;
          if (status == '0000') {
            this.selectShops = data;
          }
        })
      },
    },

    mounted() {
      this.initSearchParams();
      this.search();
    }
  }
</script>

<style lang="less" scoped>
  .deal-account-page{
    .el-form-item .el-form-item{
      margin-right: 0;
    }
    .search-by-shop {
      width: 170px;
    }

    .search-by-amount {
      width: 141px;
    }

    .item-el-w {
      width: 200px;
    }

    .select-cert {
      width: 120px;
    }

    .input-cert {
      width: 300px;
    }

    .el-form--inline .el-form-item__label {
      width: 100px !important;
    }

    .table-pagination {
      padding: 10px 0;
      text-align: right;
    }

    .el-pagination__sizes {
      margin-left: 10px;
    }

    .el-pagination__sizes .el-select {
      top: -1px;
    }
  }

</style>
