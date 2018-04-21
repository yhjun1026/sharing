<template>
  <div class="gift-return-box ffan-style">
    <div class="crumbs">
      <el-breadcrumb separator="">
        <el-breadcrumb-item normal>会员维护与应用</el-breadcrumb-item>
        <el-breadcrumb-item normal>礼品管理</el-breadcrumb-item>
        <el-breadcrumb-item>礼品退货</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content-wrap">
      <div class="search-box">
        <el-form :inline="true" :rules="rules" ref="searchForm" :model="searchForm" class="searchBox">
          <el-form-item label="会员ID:" prop="memberCode" style="margin-left:20px">
            <el-input v-model="searchForm.memberCode" style="width:220px;" size="small"
                      placeholder="输入会员17位会员ID号" ref="memberCode" @change="clearInputContent('mobile')"></el-input>
          </el-form-item>
          <el-form-item label="手机号:" prop="mobile" style="margin-left:50px">
            <el-input v-model="searchForm.mobile" ref="mobile" style="width:220px;" size="small" @change="clearInputContent('memberCode')" placeholder="输入会员11位手机号"></el-input>
          </el-form-item>
         <!-- <el-form-item label="所属广场:" prop="square">
            <el-select size="small" v-model="searchForm.orgCode" placeholder="不限" style="width:220px;">
              <el-option :label="item.orgName" :value="item.orgCode" v-for="(item, index) in orgs"
                         :key="index"></el-option>
            </el-select>
          </el-form-item>-->
          <div style="text-align:center;margin-left:30px;display: inline-block">
            <el-button class="member-list-btn" type="primary" :loading="searching" @click="searchMember()">查询
            </el-button>
            <el-button class="member-list-btn" :plain="true" type="danger" :loading="searching" @click="resetSearch()">
              重置
            </el-button>
          </div>
        </el-form>
      </div>
      <el-row class="gift-conversion-prompt" type="flex" justify="start">
        <el-col :span="20">
          <div class="grid-content">会员信息：<span class="prompt-text">请先核实会员身份再退货</span></div>
        </el-col>
      </el-row>
      <el-row class="gift-conversion-name" type="flex" justify="start"
              style="margin-top: 20px;">
        <el-col :span="4">
          <div class="grid-content bg-purple">姓名：{{ userInfo.memberName || '' }}</div>
        </el-col>
        <el-col :span="4">
          <div class="grid-content bg-purple">积分余额：{{ userInfo.points || '' }}</div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">身份证号码：{{ userInfo.certificateCode ||　'' }}</div>
        </el-col>
        <el-col :span="10">
          <div class="grid-content bg-purple">最后一次消费信息：{{ userInfo.lastConsumeInfo || '' }}</div>
        </el-col>
      </el-row>
    </div>
    <div class="gift-conversion-body">
      <el-tabs v-model="activeName2" type="card" @tab-click="handleClick">

        <el-tab-pane label="当前可退礼品" name="first">
          <div class="content-wrap">
            <el-table :data="tableData" stripe style="width: 100%" align="center"
                    :empty-text="text">
              <el-table-column prop="operationTime" label="兑换时间" align="center" width="107">
                <template scope="scope">
                  {{ scope.row.operationTime}}
                </template>
              </el-table-column>
              <el-table-column prop="giftCode" label="礼品编号" align="center" width="180">
              </el-table-column>
              <el-table-column prop="giftName" label="礼品名称" align="center"></el-table-column>
              <el-table-column prop="orgName" label="所属广场" align="center"></el-table-column>
              <el-table-column prop="exchangeCount" label="兑换数量" align="right">
                <template scope="scope">
                  {{ scope.row.exchangeCount | commafy }}
                </template>
              </el-table-column>
              <el-table-column prop="exchangeMode" label="兑换方式" align="center" width="180">
                <!--<template scope="scope">{{scope.row.exchange}}</template>-->
              </el-table-column>
              <el-table-column prop="point" label="积分价格" align="right">
                <template scope="scope">
                  {{ scope.row.point | commafy('type') }}
                </template>
              </el-table-column>
              <el-table-column prop="price" label="零售价格（元）" align="right" width="150">
                <template scope="scope">
                  {{ scope.row.price | commafy('type') }}
                </template>
              </el-table-column>
              <qf-slotaccess :code="'btn_membermnt_3_3_2'">
                <el-table-column slot="has-right" prop="address" label="操作" align="center" fixed="right">
                  <template scope="scope">
                    <qf-access :code="'btn_membermnt_3_3_2'">
                    <el-button type="text"
                               @click="exreturn(scope.$index, scope.row)">
                      退货
                    </el-button>
                    </qf-access>
                  </template>
                </el-table-column>
              </qf-slotaccess>
            </el-table>
          </div>

          <qf-access :code="'btn_membermnt_3_3_2'">
            <el-dialog title="退货" v-model="dialogFormVisible" @close="closeAddNewDialog">
              <el-form ref="form" :model="form" style="margin-right: 50px;" :rules="rules">
                <el-form-item label="退货数量：" :label-width="formLabelWidth">
                  <el-input auto-complete="off" style="width: 100px" :disabled="true" :value="quantity"></el-input>
                </el-form-item>
                <el-form-item label="备注：" :label-width="formLabel1Width" style="margin-bottom: 0px"
                              prop="remark">
                  <el-input type="textarea" :rows='rows' v-model="form.remark" style="margin-left: 27px;"
                            resize="none"></el-input>
                  <!--<div style="z-index: 100;margin-left: 460px;margin-top: -35px">{{edit}}</div>-->
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="confirmReturn" style="margin-right: 20px;width:150px">确认退货</el-button>
                <el-button @click="closeDialog" style="margin-right: 150px;width:150px">取 消</el-button>
              </div>
            </el-dialog>
          </qf-access>
        </el-tab-pane>
      </el-tabs>
    </div>
    <qf-sailfooter></qf-sailfooter>
  </div>
</template>
<script>



  import {
    mapGetters,
    mapActions
  } from 'vuex'
  export default{
    components: {


    },
    data(){
      var checkNum = (rule, value, callback) => {
        if (isNaN(value)) {
          callback(new Error('请输入数字值'));
        } else {
          if (value <= 0 || value.length < 0) {
            callback(new Error('退货数量需大于0'));
          } else {
            callback();
          }
        }
      };
      var clearInputContent = (ref) =>{
        if(!ref) return;
        this.$refs[ref].$el.value = "";
      };
      var checkRemark = (rule, value, callback) => {
        console.log(this);
        this.edit = value.length + '/100';
        if (value.length > 100) {
          callback(new Error('请输入100字以内的备注'));
        } else {
          callback();
        }
      };
      return {
        isSetable: false,
        orgs: [],
        searching: false,
        searchForm: {
          memberCode: '',
          mobile: '',
          orgCode: ''
        },
//        64721130853761024
        rules: {
          memberCode: [
            {pattern:/^\d{17}$/, message: '输入会员17位会员ID号', trigger: 'change,blur'}
          ],
          mobile: [
            {pattern:/^\d{11}$/, message: '输入会员11位手机号', trigger: 'change,blur'}
          ],
          num: [
            {required: true, validator: checkNum, trigger: 'blur'}
          ],
          remark: [
            {validator: checkRemark, trigger: 'change,blur'}
          ]
        },
        userInfo: {},
        tableData: [],
        square: [],
        activeName2: 'first',
        text: '请输入会员ID或手机号查找可退礼品',
        commonDialogVisible: false,
        dialogFormVisible: false,
        form: {
          orderId: '',
          remark: ''
        },
        formLabelWidth: '120px',
        formLabel1Width: '94px',
        rows: 10,
        quantity: 0,
        edit: "0/100"
      };
    },
    methods: {
      clearInputContent(ref){
          if(!ref) return;
          this.$refs[ref].$el.value = "";
      },
      set(){
        this.isSetable = !this.isSetable;
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      searchMember() {
        let me = this;
        this.$refs['searchForm'].validate((valid) => {
          if (valid) {
              this.searching = true;
              this.userInfo = {};
              this.axios.get('/sail/gift/orders/member', {
                params: {
                  memberCode: this.searchForm.memberCode,
                  mobile: this.searchForm.mobile
                }
              }).then(function (response) {
                 me.searching = false;
                 const {status,data} = response;
                  if (status === '0000' && data) {
                    me.userInfo = data;
                    me.getListData(me.userInfo.memberCode);
                  } else {
                    me.$message.error('会员不存在');
                  }
              }).catch((e) => {
                me.searching = false;
            })
          }
        })

      },
      resetSearch() {
        this.$refs['searchForm'].resetFields();
        this.userInfo = {};
        this.tableData = [];
        this.searchForm.orgCode = '';
      },
      getSearchParams() {
        const _this = this;
        this.axios.all([
          this.axios.get('/sail/point/getorglist'),
          this.axios.get('/sail/member/getDictionary', {
            params: {
              dictionary: 'certificate'
            }
          })]).then(this.axios.spread((geoList, certificate) => {
          const status1 = geoList.status,
            message1 = geoList.message,
            data1 = geoList.data;
          const status2 = certificate.status,
            message2 = certificate.message,
            data2 = certificate.data;
          if (status1 == '0000' && status2 == '0000') {
            //1
            this.remoteOrgs = data1;
            let orgs = [];
            Object.keys(data1).forEach(v => {
              orgs.push({
                orgCode: v,
                orgName: data1[v]
              })
            });
            this.orgs = orgs;
            if (this.orgs.length = 1) {
              this.searchForm.orgCode = this.orgs[0].orgCode;
            }
            //2
            this.certificateCode = data2;
            //3
          } else if (status1 != '0000') {
            _this.$message.error(message1);
          } else if (status2 != '0000') {
            _this.$message.error(message2);
          }
        }));
      },
      getListData(memberCode) {
        let me = this;
        this.searching = true;
        //this.searchForm.orgName = this.remoteOrgs[this.searchForm.orgCode];
        this.axios.get('/sail/gift/orders/reject/' + memberCode + '/gifts').then(response => {
          const {status, message, data} = response;
          this.searching = false;
          if (status == '0000') {
            me.tableData = data;
          } else if (status != '0000') {
            me.$message.error(message);
          }
        }).catch((e) => {
          this.searching = false;
        })
      },
      exreturn(rowIndex, row) {
        this.dialogFormVisible = true;
        this.form.orderId = row.orderId;
        this.quantity = row.exchangeCount;
      },
      confirmReturn() {
        let me = this;
//        console.log(JSON.stringify(this.form));
        this.$refs['form'].validate(valid => {
          if (valid) {
            let url = '/sail/gift/orders/reject';
            this.axios.post(url, JSON.stringify(this.form)).then(response => {
              const {status, message, data} = response;
//              console.log(response);
              if (status == '0000') {
                me.$message({
                  message: message,
                  type: 'success'
                });
                me.$refs['form'].resetFields();
                me.edit = '0/100';
                me.getListData(me.userInfo.memberCode);
                me.searchMember();
                me.dialogFormVisible = false;
              } else {
                me.$message.error(message);
              }
            }).catch(error => {
              console.log(error);
            })
          }
        })
      },
      closeDialog(){
        this.$refs['form'].resetFields();
        this.edit = '0/100';
        this.dialogFormVisible = false;
      },
      closeAddNewDialog(){
        this.form = {
          code: '',
          memberCode: '',
          num: '',
          remark: '',
          exchangeMode: []
        };
        this.$refs['form'].resetFields();
        this.edit = '0/100';
      }
    },
    mounted(){
//      this.getSearchParams();
    }
  }
</script>

<style scoped>
  .gift-return-box .search-box .el-form-item{
    margin-bottom: 0;
  }
  .search-box {
    position: relative;
    margin: 20px 0 10px 0;
  }

  .search-title {
    display: inline-block;
    font-size: 16px;
    color: #324057;
    margin-bottom: 5px;
  }

  .gift-conversion-body {
    background-color: white;
    border-radius: 6px;
    margin-bottom: 10px;
    zoom: 1;
    min-height: 400px
  }

  .gift-conversion-name {
    padding-left: 35px;
  }

  .gift-conversion-prompt {
    padding-left: 28px;
  }

  .grid-content {
    fond-size: 25px
  }

  .search-params {
    padding: 15px 30px;
  }

  .prompt-text {
    color: #ff4949
  }
</style>
