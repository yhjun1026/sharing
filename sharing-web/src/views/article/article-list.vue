<template>
  <div v-title="'物品列表'" class="deal-account-page ffan-style">
    <div class="crumbs">
      <el-breadcrumb separator="">
        <el-breadcrumb-item normal>物品管理</el-breadcrumb-item>
        <el-breadcrumb-item>物品列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content-wrap">
      <el-row type="flex" justify="end">
        <qf-access :code="'btn_membermnt_3_1_3'">
          <el-button class="largeBtn"  @click="gotoNew">
            新增物品
          </el-button>
        </qf-access>
      </el-row>
      <div class="search-box">
        <div class="searchBox">
          <el-form :inline="true" ref="searchForm" :rules="rules" :data="searchForm" :model="searchForm"
                   label-width="80px">
            <el-form-item label="物品编号:" prop="code">
              <el-input v-model="searchForm.code" placeholder="请输入物品编号" style="width:220px;"></el-input>
            </el-form-item>
            <el-form-item label="物品名称:" prop="name">
              <el-input v-model="searchForm.name" placeholder="请输入物品名称" style="width:220px;"></el-input>
            </el-form-item>
            <el-form-item label="创建时间:" prop="date">
              <el-date-picker
                v-model="date"
                type="daterange"
                :editable="false"
                @change="changeDate"
                format="yyyy-MM-dd"
                placeholder="选择日期范围">
              </el-date-picker>
            </el-form-item>
            <!--<el-form-item label="所属广场:" prop="orgCode">-->
              <!--<el-cascader v-if="orgCodeSquare==false" class="item-el-w"-->
                           <!--:options="orgs"-->
                           <!--:change-on-select="true"-->
                           <!--:clearable="true"-->
                           <!--size="small" v-model="searchForm.selectOrg" placeholder="不限"-->
                           <!--@change="changeSelectedOrg"-->
                           <!--:props="orgProps"-->
                           <!--ref="selectOrgEl"-->
                           <!--style="width:220px;"-->
              <!--&gt;</el-cascader>-->
              <!--<el-form-item v-else-if="orgCodeSquare==true">{{searchForm.square}}</el-form-item>-->
              <!--<el-select size="small" v-model="searchForm.orgCode" placeholder="不限" style="width:220px;">
                <el-option :label="item.orgName" :value="item.orgCode" v-for="(item, index) in orgs"
                           :key="index"></el-option>
              </el-select>-->

            <!--</el-form-item>-->

            <!--<el-form-item label="兑换方式:" prop="exchangeMode">-->
              <!--<el-select size="small" v-model="searchForm.exchangeMode" placeholder="不限" style="width:220px;">-->
                <!--<el-option :label="item.text" :value="item.code" v-for="(item, index) in exchangeCond"-->
                           <!--:key="index"></el-option>-->
              <!--</el-select>-->
            <!--</el-form-item>-->

            <!--<el-form-item label="积分价格:">-->
              <!--<el-form-item prop="minPoint" class="point-from">-->
                <!--<el-input class="inputmem" v-model="searchForm.minPoint" size="small"-->
                          <!--style="width:95px;"></el-input>-->
              <!--</el-form-item>-->
              <!--<el-form-item>-</el-form-item>-->
              <!--<el-form-item prop="maxPoint" class="point-to">-->
                <!--<el-input class="inputmem" v-model="searchForm.maxPoint" size="small"-->
                          <!--style="width:95px;"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-form-item>-->

          </el-form>
          <div style="text-align:center;">
            <el-button class="member-list-btn" type="primary" @click="checkAndSearch('searchForm')">查询</el-button>
            <el-button class="member-list-btn" type="danger" :plain="true" @click="resetForm">重置</el-button>
          </div>
        </div>
      </div>
      <div class="top-pagination">
        <el-pagination
          @current-change="changePage"
          @size-change="changeSize"
          :current-page="searchForm.pageIndex"
          :page-size="searchForm.pageSize"
          :page-sizes="[10, 20, 30]"
          layout="total, prev, pager, next, sizes, jumper"
          :total="totalCount">
        </el-pagination>
      </div>
      <el-table :data="giftList" stripe style="width: 100%">
        <el-table-column prop="code" label="物品编号" width="180" align="center">
          <template scope="scope">{{scope.row.code || ""}}</template>
        </el-table-column>
        <el-table-column prop="name" label="物品名称" width="180" align="center"></el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center" width="180">
          <template scope="scope">{{scope.row.createTime | formatDateTime}}</template>
        </el-table-column>
        <!--<el-table-column prop="plazaName" label="所属广场" min-width="180" align="center"></el-table-column>-->
        <el-table-column prop="currentQuantity" label="剩余库存" width="180" align="right">
          <template scope="scope">
            {{ scope.row.currentQuantity | commafy }}
          </template>
        </el-table-column>
        <el-table-column prop="exchange" label="兑换方式" width="180" align="center">
          <template scope="scope">{{scope.row.exchange}}</template>
        </el-table-column>
        <el-table-column prop="point" label="成本价格" width="180" align="right">
          <template scope="scope">
            {{ scope.row.point | commafy('type') }}
          </template>
        </el-table-column>
        <el-table-column prop="price" label="价格" width="180" align="right">
          <template scope="scope">
            {{ scope.row.price | commafy('type') }}
          </template>
        </el-table-column>
        <el-table-column prop="price" label="租用价格" width="180" align="right">
          <template scope="scope">
            {{ scope.row.price | commafy('type') }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="left" width="180" fixed="right">
          <template scope="scope">
            <el-button type="text" @click="gotoDetail(scope)">
              查看
            </el-button>
            <qf-access :code="'btn_membermnt_3_2_2'">
              <el-button type="text" @click="gotoExchange(scope.row)">
                兑换
              </el-button>
              <el-button v-if="scope.row.canDel" type="text" @click.native.prevent="gotoDel( scope,giftList)">
                删除
              </el-button>
            </qf-access>
          </template>
        </el-table-column>
      </el-table>
      <qf-access :code="'btn_membermnt_3_2_2'">
        <el-dialog title="兑换物品" v-model="dialogFormVisible" @close="closeAddNewDialog">
          <el-form ref="form" :model="form" style="margin-right: 50px;" :rules="rules">
            <el-radio-group v-model="radio" @change='changeInputLable'>
              <el-form-item>
                <el-radio class="radio" label="会员ID" style="margin-left: 10px">&nbsp;&nbsp;会员ID：
                </el-radio>
                <el-input v-model="form.memberCode" auto-complete="off" placeholder="输入会员17位会员ID号"
                          style="width: 300px;margin-left: 18px" @blur="exchangeMemberCode"
                          @focus="focusMemberCode"></el-input>
              </el-form-item>
              <div class="exchange-border"></div>
              <el-form-item>
                <el-radio class="radio" label="手机号" style="margin-left: 10px">&nbsp;&nbsp;手机号：
                </el-radio>
                <el-input size="small" v-model="num" placeholder="输入会员11位手机号" style="width: 300px;margin-left: 18px"
                          @blur="exchangeMemberCode" @focus="focusNum"></el-input>
                <el-row class="gift-exchange-prompt" type="flex" justify="start"
                        style="margin-left: 70px;margin-top: -65px">
                  <el-col style="width: 200px">
                    <div class="prompt-text"></div>
                  </el-col>
                  <el-col style="margin-left: 150px;width: 200px">
                    <div style="font-size: 18px">积分：{{point}}</div>
                  </el-col>
                </el-row>
              </el-form-item>
            </el-radio-group>
            <el-form-item label="兑换方式：" label-width="122px" prop="exchangeMode" style="margin-top:20px">
              <el-radio-group v-model="exchangeMode">
                <el-radio label="GIVE" :disabled="disGive">赠送</el-radio>
                <el-radio label="EXCHANGE" :disabled="disExchange">{{exchangepoint}}</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="兑换数量：" :label-width="formLabelWidth" prop="num" style="margin-left: 2px">
              <el-input v-model.number="form.num" auto-complete="off" style="width: 100px"></el-input>
              （库存：{{quantity}}）
            </el-form-item>
            <el-form-item label="备注：" :label-width="formLabel1Width" style="margin-bottom: 0px;" prop="remark">
              <el-input type="textarea" :rows='rows' v-model="form.remark" style="margin-left: 28px"
                        resize="none"></el-input>
              <!--<div style="z-index: 100;margin-left: 90%;margin-top: -35px">{{edit}}</div>-->
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <hr class="dialogFooterLine">
            <el-button type="primary" @click="confirmExchangeContinue" class="largeBtn">兑换并继续
            </el-button>
            <el-button @click="confirmExchange" style="margin-left: 10px;width:132px">兑换</el-button>
          </div>
        </el-dialog>
      </qf-access>
      <div class="bottom-pagination">
        <el-pagination
          @current-change="changePage"
          @size-change="changeSize"
          :current-page="searchForm.pageIndex"
          :page-size="searchForm.pageSize"
          :page-sizes="[10, 20, 30]"
          layout="total, prev, pager, next, sizes, jumper"
          :total="totalCount">
        </el-pagination>
      </div>
    </div>
    <qf-sailfooter></qf-sailfooter>
  </div>
</template>
<script>


  export default {
    components:{

    },
    data()  {
      var checkNum = (rule, value, callback) => {
        if (isNaN(value)) {
          callback(new Error('请输入数字值'));
        } else {
          if (value <= 0 || value.length < 0) {
            callback(new Error('兑换数量需大于0'));
          } else if(value > 999999){
            callback(new Error('兑换数量不能超过999999'))
          } else {
            callback();
          }
        }
      };
      var checkRemark = (rule, value, callback) => {
        this.edit = value.length + '/100';
        if (value.length > 100) {
          callback(new Error('请输入100字以内的备注'));
        } else {
          callback();
        }
      };
      return {
        square:"",
        orgCodeSquare:false,
        orgs: [],
        orgProps: {
          value: 'code',
          label: 'name',
          children: 'orgs'
        },
        searchForm: {
          square:"",
          name: "",
          code: "",
          orgCode: "",
          pageIndex: 0,
          pageSize: 10,
          exchangeMode: "",
          minPoint: "",
          maxPoint: "",
          minTime: "",
          maxTime: ""
        },
        date: "",
        exchangeCond: [{
          code: "EXCHANGE",
          text: "积分兑换"
        }, {
          code: "GIVE",
          text: "赠送"
        }],
        exchangeValue: "",
        selectShops: [],
        totalCount: 0,
        searching: false,
        giftList: [],

        dialogFormVisible: false,
        form: {
          code: '',
          exchangeMode: '',
          giftId: '',
          memberCode: '',
          num: '',
          remark: '',
        },
        formLabelWidth: '120px',
        formLabel1Width: '94px',
        formLabel2Width: '94',
        rows: 5,
        quantity: 0,
        edit: "0/100",
        radio: '1',
        point: '',
        pointCheck: '',
        radio: '会员ID',
        num: '',
        exchangeMode: 'GIVE',
        exchangepoint: '',
        rules: {
          id: {require: false, pattern: /^(0|\+?[1-9][0-9]*)$/, message: '只能输入数字'},
          mobile: {type: '', pattern: /^1[345678]\d{9}$/, message: '请输入正确手机号', trigger: 'blur,change'},
          num: [
            {required: true, validator: checkNum}
          ],
          remark: [
            {validator: checkRemark, trigger: 'change,blur'}
          ],
          minPoint: {require: false, pattern:  /^(?:0|[1-9]{1}\d{0,5})$/, message: '积分数范围0-999999'},
          maxPoint: {require: false, pattern:  /^(?:0|[1-9]{1}\d{0,5})$/, message: '积分数范围0-999999'}
        },
        disGive: false,
        disExchange: false
      }
    },
    methods: {
      gotoNew(){
        this.$router.push({
          path: '/member/memberintegral/newgift'
        })
      },
      gotoDetail(scope){
        this.$router.push({
          name: "giftDetail",
          query: {
            id: scope.row.id

          }
        })
      },
      gotoExchange(row){
        /*this.$message({
         type: "info",
         message: "开发中。。。"
         });*/
        this.disExchange = false;
        this.disGive = false;
        this.exchangeMode = 'GIVE';
        this.dialogFormVisible = true;
        this.form.code = row.code;
        // this.form.memberCode = this.searchForm.memberCode;
        this.quantity = row.currentQuantity;
        this.exchangepoint = '积分兑换' + '（' + row.point + '）';
        this.form.giftId = row.id;
        if (row.exchangeModes.length === 1) {
//          console.log(row.exchangeModes[0]);
          if (row.exchangeModes[0] === 'GIVE') {
            this.disExchange = true;
          } else if (row.exchangeModes[0] === 'EXCHANGE') {
            this.disGive = true;
            this.exchangeMode = 'EXCHANGE';
          }
        }
      },
      gotoDel(scope, giftList){
        this.$confirm('是否确认删除该信息', '提示', {
          confirmButtonText: '删除',
          cancelButtonText: '再想想',
          type: 'warning'
        }).then(() => {
          this.sendDelApi(scope.row.id, (res) => {
          if (res.data) {
          giftList.splice(scope.$index, 1);
          this.totalCount--;
        }
        this.$message(res);
      })
      }).catch(() => {
          this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
      },
      sendDelApi(id, callback){
        this.axios.get(`/sail/gifts/${id}/deleteById`)
          .then((res) => {
          if (res.status === "0000" && res.data === true) {
          callback({
            type: "success",
            data: res.data,
            message: '删除成功!'
          });
        } else {
          callback({
            type: "error",
            message: res.message
          })
        }
      })
      },
      dealItemData(giftItem){
        /* const exchangeModes = giftItem.exchangeModes;
         const modes = {
         "GIVE": "赠送",
         "EXCHANGE": `积分兑换`
         };
         const point = giftItem.point;
         exchangeModes.forEach(function (item, index) {
         exchangeModes[index] = modes[item];
         });
         giftItem.exchange = exchangeModes.join('、');*/
        let exchangeModes = giftItem.exchangeModes;
        const modes = {
          "GIVE": "赠送",
          "EXCHANGE": `积分兑换`
        };
        const point = giftItem.point;
        let tempEx = [];
        exchangeModes.forEach(function (item, index) {
          tempEx.push(modes[item]);
          //exchangeModes[index] = modes[item];
        });
        giftItem.exchange = tempEx.join('、');
      },
      dealData(){
        let giftList = this.giftList;
        giftList.forEach((item) => {
          this.dealItemData(item);
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
      /*     initSearchParams(){
       this.axios.all([
       this.axios.get('sail/member/scopes', {
       params: {
       type: 2
       }
       }),
       this.axios.get('/sail/gifts/exchangeModes')
       ]).then(this.axios.spread((orgs, exchangeRes) => {
       if (orgs.status == '0000' && exchangeRes.status == '0000') {
       //1 scopes

       this.orgs = orgs.data;
       if (this.orgs.length = 1) {
       this.searchForm.orgCode = this.orgs[0].orgCode;
       }
       //this.exchangeCond = exchangeRes.data;
       //              console.log(exchangeRes);
       }
       })
       );
       },*/
      changeSize(newSize) {
        this.searchForm.pageSize = newSize;
        this.getList();
      },
      changePage(newPage) {
        if(this.searchForm.pageIndex === newPage){
          return;
        }
        this.searchForm.pageIndex = newPage;
        this.getList();
      },

      changeDate(date) {
        const values = date.split(' - ');
        this.searchForm.minTime = +new Date(values[0]+" 00:00:00");
        this.searchForm.maxTime = +new Date(values[1]+" 24:00:00");
      },
      getSquare(){
        var code=store.state.accounts.org.code;
        var square=store.state.accounts.org.name;
        this.searchForm.square=square;
        //todo： 由于登录用户的数据里缺少组织的类型，无法判断是否是广场会员
        //todo：所以暂时使用文案来判断，612的时候需要修改这个逻辑。
        // @林家颖
        if(square.indexOf('广场') > 0){
          this.orgCodeSquare=true;
        }
      },
      resetForm(){
        this.$refs['searchForm'].resetFields();
        if(this.orgCodeSquare===true){
          var square=store.state.accounts.org.name;
          this.searchForm.square=square;
        }
//        this.searchForm = {
//          orgCode: "",
//          pageIndex: 0,
//          pageSize: 10,
//          exchangeMode: "",
//          minTime: "",
//          maxTime: "",
//          minPoint: "",
//          maxPoint: ""
//        };
//        this.searchForm.square=this.searchForm.square;
        this.date = "";
        this.$refs["selectOrgEl"] && this.$refs["selectOrgEl"].handlePick([],true);
      },
      checkAndSearch(formName){
        this.search();
//          return;
//        this.$refs[formName].validate((valid) => {
//          if (valid) {
//            this.search();
//          } else {
//            console.log('error submit!!');
//            return false;
//          }
//        });
      },
      search() {
        this.searchForm.pageIndex = 0;
        this.getList();
      },
      getList() {
        let self = this;
        this.searching = true;
        let searchParams = {};
        Object.assign(searchParams, this.searchForm);
        for (var i in searchParams) {
          if (searchParams[i] === "") {
            delete(searchParams[i]);
          }
        }
        console.log(this.searchForm);
        this.axios.post('/sail/gifts/search',
          searchParams
        ).then(response => {
          const {status, message, data, _metadata} = response;
        if (status == '0000') {

          self.giftList = data;
          self.dealData();
          self.totalCount = _metadata.totalCount;
        } else {
          self.$message.error(message);
        }
        self.searching = false;
      }).catch(error => {
          this.searching = false;
        console.error(error);
      });
      },
      exchange(row){
//        this.qcodes = row;
        this.disExchange = false;
        this.disGive = false;
        this.exchangeMode = 'GIVE';
        this.dialogFormVisible = true;
        this.form.code = row.code;
        this.form.memberCode = "";
        this.quantity = row.currentQuantity;
        this.exchangepoint = '积分兑换' + '（' + row.point + '）';
        this.form.giftId = row.id;
        console.log(row.exchangeModes.length);
        if (row.exchangeModes.length === 1) {
          console.log(row.exchangeModes[0]);
          if (row.exchangeModes[0] === 'GIVE') {
            this.disExchange = true;
          } else if (row.exchangeModes[0] === 'EXCHANGE') {
            this.disGive = true;
            this.exchangeMode = 'EXCHANGE';
          }
        }
      },
      closeAddNewDialog(){
        this.form = {
          code: '',
          memberCode: '',
          num: '',
          remark: '',
          exchangeMode: ''
        },
          this.$refs['form'].resetFields();
        this.edit = '0/100';
        this.radio = '会员ID';
        this.point = '';
        this.num = ''
      },
      changeInputLable(lable){
        this.form.memberCode = '';
        this.num = '';
        this.point = '';
      },
      confirmExchange() {
        let me = this;
//        console.log(this.form.memberCode);
        if (this.form.num > this.quantity) {
          this.$message.error('兑换数需小于等于库存数');
        } else if (this.form.memberCode===undefined||this.form.memberCode.length <= 0) {
          this.$message.error('请先核实会员身份');
        }
        else {
          this.form.exchangeMode = this.exchangeMode;
          console.log(this.form);
          this.$refs['form'].validate(valid => {
            if (valid) {
              let url = '/sail/gift/orders/exchange';
              this.axios.post(url, JSON.stringify(this.form)).then(response => {
                const {status, message, data} = response;
              if (status == '0000') {
                me.$message({
                  message: message,
                  type: 'success'
                });
                me.$refs['form'].resetFields();
                me.loading2 = 'false';
                me.getList();
                this.dialogFormVisible = false;
              } else {
                this.$message.error(message);
              }
            }).catch(error => {
//                console.log(error);
              })
            }
          })
        }
      },
      confirmExchangeContinue(){
        let me = this;
        if (this.form.num > this.quantity) {
          this.$message.error('兑换数需小于等于库存数');
        } else if (this.form.memberCode===undefined||this.form.memberCode.length <= 0) {
          this.$message.error('请先核实会员身份');
        } else {
          this.form.exchangeMode = this.exchangeMode;
          this.$refs['form'].validate(valid => {
            if (valid) {
              let url = '/sail/gift/orders/exchange';
              this.axios.post(url, JSON.stringify(this.form)).then(response => {
                const {status, message, data} = response;
              if (status == '0000') {
                me.$message({
                  message: message,
                  type: 'success'
                });
                me.quantity = me.quantity - me.form.num;
                me.$refs['form'].resetFields();
                me.point = '';
                me.form.memberCode = '';
                me.num = '';
                me.edit = '0/100';
                me.getList();
              } else {
                this.$message.error(message);
              }
            }).catch(error => {
                console.log(error);
            })
            }
          })
        }
      },
      exchangeMemberCode(){
        let me = this;
        this.form.memberCode = String(this.form.memberCode).trim() || ""
        this.num = String(this.num).trim() || ""
        if (isNaN(this.form.memberCode) || isNaN(this.num)) {
          me.$message.error('请输入数字值');
        } else {
          if ((this.num.length != 11 && this.num.length > 0)) {
            me.$message.error('输入会员11位手机号');
          } else if ((this.form.memberCode.length != 17 && this.form.memberCode.length > 0)) {
            me.$message.error('输入会员17位会员ID号');
          }
          else if (this.form.memberCode.length <= 0 && this.num.length <= 0) {
//            me.$message.error('请输入会员ID或手机号查找');
            return;
          }
          else {
            this.axios.get('/sail/gift/orders/member', {
              params: {
                memberCode: this.form.memberCode,
                mobile: this.num
              }
            }).then(function (response) {
              const {status, data} = response;
              if (status === '0000' && data) {
                me.form.memberCode = response.data.memberCode;
                me.num = response.data.mobileNo;
                me.point = response.data.points;
              } else {
                me.$message.error('会员不存在');
              }
              me.searching = false;
            })
          }
        }
      },
      focusMemberCode(){
        this.radio = '会员ID'
      },
      focusNum(){
        this.radio = '手机号'
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
      initSearchParams(){
        this.axios.all([
          this.axios.get('/sail/merchant/roles/plazaTypeRole/orgs/tree')
          /* ,
           this.axios.get('/sail/member/getDictionary', {
           params: { dictionary: 'certificate' }
           })*/
        ]).then(this.axios.spread((orgs) => {
            if (orgs.status == '0000'&& orgs.data!=null) {
          //1 scopes
          this.orgs = this.formattedOrgs([orgs.data]);
//              console.log(orgs.data)
//              实现：当登录为集团时，所属广场为下拉框  当登录为广场时  所属广场为当前广场  没有下拉框
          if(orgs.data.orgs==null){
            var code=store.state.accounts.org.code;
            var square=store.state.accounts.org.name;
            this.searchForm.square=square;
            this.orgCodeSquare=true;
          }
        }
      })
      );
      },

    },
    mounted() {
      //console.log(store.state.accounts);
//      this.getSquare();
      this.initSearchParams();
      this.getList();
    }
  }
</script>
<style lang="less">
  .deal-account-page{
  .el-cascader--small .el-cascader__label{
    line-height:36px;
  }
  }
</style>
<style scoped lang="less">
  .deal-account-page {
  .search-box {
    position: relative;
  .search-title {
    display: inline-block;
    font-size: 16px;
    font-weight: bold;
    color: #324057;
    margin-top: 20px;
  }
  }
  .plus-btn {
    position: absolute;
    right: 0px;
    top: 8px;
  }
  .point-from .el-form-item__error{
    width:200px;
  }
  .point-to .el-form-item__error{
    width:200px;
  }
  }

  .deal-account-page .search-by-shop {
    width: 170px;
  }

  .deal-account-page .search-by-amount {
    width: 141px;
  }

  .deal-account-page .item-el-w {
    width: 300px;
  }

  .deal-account-page .select-cert {
    width: 120px;
  }

  .deal-account-page .input-cert {
    width: 300px;
  }

  .deal-account-page .el-form--inline .el-form-item__label {
    width: 100px !important;
  }

  .deal-account-page .table-pagination {
    padding: 10px 0;
    text-align: right;
  }

  .deal-account-page .el-pagination__sizes {
    margin-left: 10px;
  }

  .deal-account-page .el-pagination__sizes .el-select {
    top: -1px;
  }

  .gift-exchange-prompt {
    padding-left: 48px;
  }

  .prompt-text {
    color: #f00
  }

  .exchange-border {
    border-top: 1px solid #a5a5a6;
    border-right: 1px solid #a5a5a6;
    border-bottom: 1px solid #a5a5a6;
    margin-top: -38px;
    margin-bottom: -18px;
    margin-left: 390px;
    width: 50px;
    height: 65px;
  }
</style>
