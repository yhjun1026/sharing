<template>
  <div class="gift-conversion-box ffan-style">
    <div class="crumbs">
      <el-breadcrumb separator="">
        <el-breadcrumb-item normal>会员维护与应用</el-breadcrumb-item>
        <el-breadcrumb-item normal>礼品管理</el-breadcrumb-item>
        <el-breadcrumb-item>礼品兑换</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content-wrap">
      <div class="search-box">
        <div class="searchBox">
          <el-form :inline="true" :rules="rules" ref="searchForm" :model="searchForm">
            <el-form-item label="会员ID:" prop="memberCode" style="margin-left:20px">
              <el-input v-model="searchForm.memberCode" style="width:220px;" size="small"
                        placeholder="输入会员17位会员ID号"></el-input>
            </el-form-item>
            <el-form-item label="手机号:" prop="mobile" style="margin-left:50px">
              <el-input v-model="searchForm.mobile" style="width:220px;" size="small"
                        placeholder="输入会员11位手机号"></el-input>
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
              <el-button class="member-list-btn" :plain="true" type="danger" :loading="searching"
                         @click="resetSearch()">
                重置
              </el-button>
            </div>
          </el-form>
        </div>
      </div>
      <el-row class="gift-conversion-prompt" type="flex" justify="start">
        <el-col :span="20">
          <div class="grid-content">会员信息：<span class="prompt-text">请先核实会员身份再兑换礼品</span></div>
        </el-col>
      </el-row>
      <el-row class="gift-conversion-name" type="flex" justify="start"
              style="margin-top: 20px;">
        <el-col :span="4">
          <div class="grid-content bg-purple">姓名：{{ userInfo.memberName }}</div>
        </el-col>
        <el-col :span="4">
          <div class="grid-content bg-purple">积分余额：{{ userInfo.points }}</div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">身份证号码：{{ userInfo.certificateCode }}</div>
        </el-col>
        <el-col :span="10">
          <div class="grid-content bg-purple">最后一次消费信息：{{ userInfo.lastConsumeInfo }}</div>
        </el-col>
      </el-row>
    </div>
    <div class="gift-conversion-body">
      <el-tabs v-model="activeName2" type="card" @tab-click="handleClick" stripe>
        <el-tab-pane label="当前可兑换礼品" name="first">
          <div class="content-wrap">
            <el-table :data="tableData1" style="width: 100%" v-if="!isSetable" align="center"
                    :empty-text="text">
              <el-table-column prop="code" label="礼品编号" align="center" width="180">
              </el-table-column>
              <el-table-column prop="name" label="礼品名称" align="center"></el-table-column>
              <el-table-column prop="plazaName" label="所属广场" align="center"></el-table-column>

              <el-table-column prop="currentQuantity" label="剩余库存" align="right">
                <template scope="scope">
                  {{ scope.row.currentQuantity | commafy }}
                </template>
              </el-table-column>
              <el-table-column prop="exchange" label="兑换方式" align="center" width="180">
                <template scope="scope">{{scope.row.exchange}}</template>
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
              <qf-slotaccess :code="'btn_membermnt_3_2_2'">
                <el-table-column slot="has-right" prop="address" label="操作" align="center" fixed="right">
                  <template scope="scope">
                    <qf-access :code="'btn_membermnt_3_2_2'">
                      <el-button type="text"
                                 @click="exchange(scope.$index, scope.row)">
                        兑换
                      </el-button>
                    </qf-access>
                  </template>
                </el-table-column>
              </qf-slotaccess>

            </el-table>
          </div>
          <qf-access :code="'btn_membermnt_3_2_2'">
            <el-dialog title="兑换礼品" v-model="dialogFormVisible" @close="closeAddNewDialog">
              <el-form ref="form" :model="form" style="margin-right: 50px;" :rules="rules">
                <el-radio-group>
                  <el-form-item label="会员ID：" label-width="122px">
                    <el-input v-model="form.memberCode" auto-complete="off"
                              style="width: 300px;" @blur="exchangeMemberCode"
                              @focus="focusMemberCode" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="手机号：" label-width="122px">
                    <el-input size="small" v-model="num" style="width: 300px;"
                              @blur="exchangeMemberCode" @focus="focusNum" :disabled="true"></el-input>
                  </el-form-item>
                  <el-form-item label="积分余额：" style="width: 440px;" label-width="122px">
                    <span>{{point}}</span>
                  </el-form-item>
                </el-radio-group>
                <el-form-item label="兑换方式：" label-width="122px" prop="exchangeMode">
                  <el-radio-group v-model="exchangeMode" @change='checkNum'>
                    <el-radio label="GIVE" :disabled="disGive">赠送</el-radio>
                    <el-radio label="EXCHANGE" :disabled="disExchange">{{exchangepoint}}</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="兑换数量：" :label-width="formLabelWidth" prop="num" style="margin-left: 2px">
                  <el-input v-model.number="form.num" auto-complete="off" style="width: 100px"></el-input>
                  （库存：{{quantity}}）
                </el-form-item>
                <el-form-item label="备注：" :label-width="formLabelWidth" style="margin-bottom: 0px;" prop="remark">
                  <el-input type="textarea" :rows='rows' v-model="form.remark" style=""
                            resize="none"></el-input>
                  <!--<div style="z-index: 100;margin-left: 90%;margin-top: -35px">{{edit}}</div>-->
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <hr class="dialogFooterLine">
                <el-button type="primary" @click="confirmExchange" style="margin-right: 20px;width:150px">兑换</el-button>
                <el-button @click="closeDialog" style="width:150px">取消
                </el-button>
              </div>
            </el-dialog>
          </qf-access>
        </el-tab-pane>
        <el-tab-pane label="兑换记录" name="second">
          <div class="content-wrap">
            <el-table :data="tableData2" style="width: 100%" v-if="!isSetable" align="center">
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
            </el-table>
          </div>

        </el-tab-pane>
      </el-tabs>
    </div>
    <qf-sailfooter></qf-sailfooter>
  </div>
</template>
<script>


  import store from '@/store';
  import {
    mapGetters,
    mapActions
  } from 'vuex'
  export default{
    components: {},
    data(){
      var checkNum = (rule, value, callback) => {
        if (isNaN(value)) {
          callback(new Error('请输入数字值'));
        } else {
          if (value <= 0 || value.length < 0) {
            callback(new Error('兑换数量需大于0'));
          } else if (value > 999999) {
            callback(new Error('兑换数量不能超过999999'))
          } else {
            callback();
          }
        }
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
            {pattern: /^\d{17}$/, message: '输入会员17位会员ID号', trigger: 'change,blur'}
          ],
          mobile: [
            {pattern: /^\d{11}$/, message: '输入会员11位手机号', trigger: 'change,blur'}
          ],
          num: [
            {required: true, validator: checkNum}
          ],
          remark: [
            {validator: checkRemark, trigger: 'change,blur'}
          ],
          exchangeMode: [
            {required: true, trigger: 'blur'}
          ]

        },
        userInfo: {},
        tableData1: [],
        tableData2: [],
        square: [],
        activeName2: 'first',
        text: '请输入会员ID或手机号查找可兑换礼品',
        commonDialogVisible: false,
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
        point: '100',
        pointCheck: '',
        radio: '会员ID',
        num: '',
        exchangeMode: 'GIVE',
        exchangepoint: '',
        disGive: false,
        disExchange: false
      };
    },
    methods: {
      set(){
        this.isSetable = !this.isSetable;
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      searchMember() {
        let me = this;
        if (this.searchForm.memberCode.length <= 0 && this.searchForm.mobile.length <= 0) {
          me.$message.error('请输入会员ID或手机号查找可兑换礼品');
        } else {
          this.searching = true;
          this.userInfo = {};
          this.axios.get('/sail/gift/orders/member', {
            params: {
              memberCode: this.searchForm.memberCode,
              mobile: this.searchForm.mobile
            }
          }).then(function (response) {
            me.searching = false;
//              console.log(response);
//              return;
//            if (response.status === '0000') {
//                if(response.data!=null){
//                  me.userInfo = response.data;
//                  me.getListData(me.userInfo.memberCode);
//                }
//                else {
//                  me.$message.error('会员不存在');
//                }
//            }
            me.searching = false;
            const {status, data} = response;
            if (status === '0000' && data) {
              me.userInfo = data;
              me.getListData(me.userInfo.memberCode);
            } else {
              me.$message.error('会员不存在');
            }
          })
        }
      },
      resetSearch() {
        this.$refs['searchForm'].resetFields();
        this.userInfo = {};
        this.tableData1 = [];
        this.tableData2 = [];
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
        let orgCode = this.searchForm.orgCode;
//        console.log(this);
        if (this.searchForm.orgCode == "") {
          orgCode = store.state.accounts.org.code;
        }
        this.axios.all([
          this.axios.get('/sail/gift/orders/exchange/' + memberCode + '/orders'),
          this.axios.get('/sail/gift/orders/exchange/gifts/v2', {
            params: {
              orgCode: orgCode,
              memberCode: memberCode
            }
          })]).then(this.axios.spread((orders, gifts) => {
          const status1 = orders.status,
            message1 = orders.message,
            data1 = orders.data;

          const status2 = gifts.status,
            message2 = gifts.message,
            data2 = gifts.data;
          if (status2 == '0000') {
            me.tableData1 = data2;

            me.dealData();
            if (me.tableData1.length <= 0) {
              me.text = '该会员暂无可兑换礼品兑换'
            }
          }
          if (status1 == '0000') {
            me.tableData2 = data1;
//            me.dealData1();
          }
          else if (status1 != '0000') {
            me.$message.error(message1);
          } else if (status2 != '0000') {
            me.$message.error(message2);
          }
          me.searching = false;
        }))
      },
      exchange(rowIndex, row) {
        this.disExchange = false;
        this.disGive = false;
        this.exchangeMode = 'GIVE';
        this.dialogFormVisible = true;
        this.form.code = row.code;
        this.form.memberCode = this.userInfo.memberCode;
        this.quantity = row.currentQuantity;
        this.point = this.userInfo.points;
        this.exchangepoint = '积分兑换' + '（' + row.point + '）';
        this.form.giftId = row.id;
        this.num = this.searchForm.mobile;
        if (row.exchangeModes.length === 1) {
          console.log(row.exchangeModes[0]);
          if (row.exchangeModes[0] === 'GIVE') {
            this.disExchange = true;
          } else if (row.exchangeModes[0] === 'EXCHANGE') {
            this.disGive = true;
            this.exchangeMode = 'EXCHANGE';
          }
        }
        if (this.searchForm.mobile.length > 0 && this.searchForm.memberCode.length <= 0) {
          this.radio = '手机号'
        } else {
          this.radio = '会员ID'
        }
//        console.log(this.form);
      },
      confirmExchange() {
        let me = this;
        if (this.form.num > this.quantity) {
          this.$message.error('兑换数需小于等于库存数');
        } else if (this.form.memberCode.length <= 0) {
          this.$message.error('请先核实会员身份');
        } else {

          this.form.exchangeMode = this.exchangeMode;
//          console.log(JSON.stringify(this.form));
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
                  me.getListData(me.userInfo.memberCode);
                  me.searchMember();
                  this.dialogFormVisible = false;
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
      closeDialog(){
        this.$refs['form'].resetFields();
        this.dialogFormVisible = false;
        this.disExchange = false;
        this.disGive = false;
      },
      closeAddNewDialog(){
        this.form = {
          code: '',
          memberCode: '',
          num: '',
          remark: '',
          exchangeMode: 'GIVE'
        };
        this.$refs['form'].resetFields();
        this.edit = '0/100';
        this.radio = '会员ID';
      },
      checkNum(lable){
//        if (lable == '手机号') {
//          this.form.memberCode = '';
//        } else {
//          this.num = '';
//        }
      },
      confirmExchangeContinue(){
        let me = this;
        if (this.form.num > this.quantity) {
          this.$message.error('兑换数需小于等于库存数');
        } else if (this.form.memberCode.length <= 0) {
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
                  me.edit = '0/100';
                  me.getListData(me.userInfo.memberCode);
                  me.searchMember();
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
        if (isNaN(this.form.memberCode) || isNaN(this.num)) {
          me.$message.error('请输入数字值');
        } else {
          if ((this.num.length != 11 && this.num.length > 0)) {
            me.$message.error('输入会员11位手机号');
          } else if ((this.form.memberCode.length != 17 && this.form.memberCode.length > 0)) {
            me.$message.error('输入会员17位会员ID号');
          }
          else if (this.form.memberCode.length <= 0 && this.num.length <= 0) {
            return;
          } else {
            this.axios.get('/sail/gift/orders/member', {
              params: {
                memberCode: this.form.memberCode,
                mobile: this.num
              }
            }).then(function (response) {
              if (response.status === '0000') {
                me.form.memberCode = response.data.memberCode;
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
      dealItemData(giftItem){
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
        let giftList = this.tableData1;
        giftList.forEach((item) => {
          this.dealItemData(item);
        })
      },
      dealData1(){
        let giftList = this.tableData2;
        giftList.forEach((item) => {
          this.dealItemData(item);
        })
      }
    },
    mounted(){
//      this.getSearchParams();
    }
  }
</script>

<style lang="less" scoped>
  .gift-conversion-box .search-box .el-form-item {
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

  .gift-exchange-prompt {
    padding-left: 48px;
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
