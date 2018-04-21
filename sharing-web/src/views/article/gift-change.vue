<!-- 礼品兑换 -->

<template>
	<div class="ffan-style">
		<div class="crumbs">
	    <el-breadcrumb separator="">
        <el-breadcrumb-item normal>会员维护与应用</el-breadcrumb-item>
        <el-breadcrumb-item normal>礼品管理</el-breadcrumb-item>
        <el-breadcrumb-item >礼品兑换</el-breadcrumb-item>
  		</el-breadcrumb>
    </div>

    <div class="content-wrap">
    	<div class="search-box" v-if="showSearchParams">
				<el-form :inline="true" ref="searchForm" :model="searchForm" class="search-params integral-addition-member">
					<el-form-item class="integral-addition-memberID" label="会员ID:" prop="memberCode">
				    <el-input size="small" v-model="searchForm.memberCode" placeholder="输入会员ID" style="width:220px;"></el-input>
		 		  </el-form-item>
					<el-form-item class="integral-addition-phone" label="手机号码:" prop="mobile">
				    <el-input size="small" v-model="searchForm.mobile" placeholder="输入手机号" style="width:220px;"></el-input>
		 		  </el-form-item>
		 		  <el-form-item label="所属广场:" prop="orgCode">
				  	<el-select v-model="searchForm.orgCode" size="small"
				  		style="width:220px;">
				      <el-option v-for="(org, index) in orgs" :key="index"
				      	:label="org.orgName" :value="org.orgCode"></el-option>
				    </el-select>
				  </el-form-item>
 		  	  <div style="text-align:center">
		 		  	<el-col :span="6" style="text-align:right;">
					    <el-button class="integral-addition-btn" type="primary" :loading="searching"
					    	@click="searchMember()">
					    	查询
				    	</el-button>
					    <el-button class="integral-addition-btn" :plain="true" type="danger" :loading="searching"
					    	@click="resetSearch()">
					    	重置
				    	</el-button>
				 		</el-col>
		 			</div>
				</el-form>
    	</div>

			<el-row class="integral-addition-name" type="flex" justify="start"
				style="margin-top: 20px;">
				<el-col :span="4" class="member-info">
					姓名：{{ userInfo.name }}
				</el-col>
				<el-col :span="4" class="member-info">
					状态：{{ userInfo.memberStatus }}
				</el-col>
				<el-col :span="4" class="member-info">
					积分余额：{{ userInfo.points }}
				</el-col>
				<el-col :span="4" class="member-info">
					会员等级：{{ userInfo.rating }}
				</el-col>
			</el-row>
	</div>
	<div class="integral-addition-body">
			<div style="text-align:right;margin-bottom:20px;">
				<qf-access :code="'btn_membermnt_1_2_1'">
					<el-button icon="plus"
						:disabled="!userValid"
						@click="addAdditionLine()">
						添加补录信息
					</el-button>
				</qf-access>
			</div>
			<div class="integral-addition-table">
			<el-table  ref="memberList"  :data="additions" stripe style="width: 100%">
		    <el-table-column prop="storeName" label="商铺" width="200">
		    	<template scope="scope" >
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_0'"
		    			:model="additions[scope.$index]" >
		    			<el-form-item prop="storeName"
	              :rules="[
	                { required: true, message: '请选择添加商铺', trigger: 'change, blur'}
	              ]">
	              <el-input size="small"
				    			v-model="additions[scope.$index].storeName"
				    			:readonly="true" icon="search"
				    			:disabled="!userValid"
				    			placeholder="搜索添加商铺"
				    			@focus="showShopDialog(scope.$index)"></el-input>
              </el-form-item>
		    		</el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column prop="consumptionTime" label="消费时间" width="260">
		    	<template scope="scope">
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_1'"
		    			:model="additions[scope.$index]" >
		    			<el-form-item prop="consumptionTime"
	              :rules="[
	                { required: true, type: 'date', message: '请选择消费时间', trigger: 'blur'}
	              ]">
					    	<el-date-picker size="small" type="datetime" :editable="false"
				    			:disabled="!userValid" placeholder="选择日期"
				    			v-model="additions[scope.$index].consumptionTime"
		              :picker-options="pickerOptions"
		              @change="consumptionTimeChanged(scope.$index)"
		              format="yyyy-MM-dd HH:mm:ss"></el-date-picker>
              </el-form-item>
		    		</el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column prop="serialNo" label="终端号" width="200">
		    	<template scope="scope">
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_2'"
		    			:model="additions[scope.$index]" >
		    			<el-form-item prop="serialNo"
	              :rules="[
	                { required: true, message: '请填写终端号', trigger: 'change'}
	              ]">
	              <el-input size="small" :disabled="!userValid"
				    			v-model="additions[scope.$index].serialNo"></el-input>
            	</el-form-item>
          	</el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column prop="transactionNo" label="交易号" width="200">
		    	<template scope="scope">
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_3'"
		    			:model="additions[scope.$index]" >
		    			<el-form-item prop="transactionNo"
	              :rules="[
	                { required: true, message: '请填写交易号', trigger: 'change'}
	              ]">
								<el-input size="small" :disabled="!userValid"
									v-model="additions[scope.$index].transactionNo"></el-input>
              </el-form-item>
            </el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column prop="amount" label="消费金额" width="200">
		    	<template scope="scope">
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_4'"
		    			:model="additions[scope.$index]">
			    		<el-form-item prop="amount"
	              :rules="[
	                { required: true,  message: '请填写消费金额', trigger: 'blur' },
	                { validator: checkNumber, trigger: 'change,blur'}
	              ]">
				    		<el-input size="small" :disabled="!userValid"
				    			v-model="additions[scope.$index].amount"
				    			@blur="calculateIntegral(scope.row, scope.$index)"></el-input>
              </el-form-item>
            </el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column prop="point" label="积分" width="200">
		    	<template scope="scope">
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_5'"
		    			:model="additions[scope.$index]" >
			    		<el-form-item prop="point">
				    		<el-input size="small" :disabled="true"
				    			v-model="additions[scope.$index].point"
				    			placeholder="输入金额后计算积分" ></el-input>
              </el-form-item>
            </el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column prop="comments" label="备注" width="200">
		    	<template scope="scope">
		    		<el-form :inline="true" :ref="'addForm_' + scope.$index + '_6'"
		    			:model="additions[scope.$index]" >
			    		<el-form-item prop="comments"
			    			:rules="[
									{ max: 70, message: '最长70个字符'}
				  			]">
				    		<el-input type="textarea"
								  :autosize="{ minRows: 2, maxRows: 4}"
				    			:disabled="!userValid" placeholder="请输入备注"
								  v-model="additions[scope.$index].comments"
								  resize="none" >
								</el-input>
              </el-form-item>
            </el-form>
		    	</template>
		    </el-table-column>
		    <el-table-column fixed="right" label="操作" width="80">
		      <template scope="scope">
		        <el-button type="text"
		    			:disabled="!userValid"
		    			@click="resetAdditionLine(scope.$index)">
		        	重置
	        	</el-button>
		        <el-button v-if="scope.$index !== 0" type="danger"
		    			:disabled="!userValid"
		    			@click="deleteAdditionLine(scope.$index)">
		        	删除
	        	</el-button>
		      </template>
		    </el-table-column>
		  </el-table>
		</div>
		  <div style="text-align:center;margin: 20px 0">
        <qf-access :code="'btn_membermnt_1_2_1'">
          <el-button class="integral-addition-submit" type="info" :loading="submiting"
	    			:disabled="!userValid"
            @click="submitAdditions()">提交审核</el-button>
        </qf-access>
		  	<el-button class="integral-addition-cancel" :loading="submiting"
    			:disabled="!userValid"
		  	  @click="cancelHandler">取消</el-button>
		  </div>

			<el-dialog title="搜索商铺" v-model="shopDialogVisible" size="small"
				:close-on-press-escape="false" :close-on-click-modal="false"
				@close="closeShopDialog()">
			  <el-row style="margin-bottom:20px;">
			  	<el-input placeholder="请输入代码或者名称进行搜索"
					  v-model="searchShopParam" @change="searchParamChange"></el-input>
			  </el-row>
			  <el-table :data="searchedShops" style="width: 100%;" max-height="250"
					highlight-current-row @current-change="selectShopChange">
		      <el-table-column prop="code" label="代码" width="200">
		      </el-table-column>
		      <el-table-column prop="name" label="名称">
		      </el-table-column>
		    </el-table>
		    <div style="margin:10px 0;text-align:right;">
				  <el-pagination
			      @current-change="changePage"
			      :current-page="searchShopParams.pageIndex"
      			:page-size="searchShopParams.pageSize"
			      layout="total, prev, pager, next"
			      :total="shopCount">
			    </el-pagination>
				</div>
			  <div style="text-align:center;margin-top:20px;">
			    <el-button type="primary" size="small" @click="selectShopHandler()">确定</el-button>
			    <el-button type="primary" :plain="true" size="small"
			    	@click="shopDialogVisible = false">
			    	取消
		    	</el-button>
			  </div>
			</el-dialog>
    </div>
    <qf-sailfooter></qf-sailfooter>
	</div>
</template>

<script>
	
	
	export default {
		components: {
		},
		data: function() {
			return {
				searchForm: {
					memberCode: '',
					mobile: ''
				},
				showSearchParams: false,
				searching: false,
				userInfo: {},
				shopDialogVisible: false,
				submiting: false,
				searchShopParam: '',
				searchedShops: [],
				selectedShop: null,
				additionLineIndex: null,
				additions: [{
					storeId: '',
					storeName: '',
					basicFormatId: '',
					consumptionTime: '',
					amount: '',
					point: '',
					serialNo: '',
					transactionNo: '',
					comments: ''
				}],
				searchShopParams: {
					code: '',
					name: '',
					status: 1,
					pageSize: 20,
					pageIndex: 1
				},
				shopCount: 0,
				pickerOptions: {
					disabledDate(time) {
            return time.getTime() > Date.now();
          }
				}
			}
		},
		computed: {
			userValid() {
				const { userInfo } = this;
				return userInfo.name && userInfo.name.length > 0 && userInfo.memberStatus != '冻结';
			}
		},
		methods: {
			checkNumber(rule, value, callback){
				let reg=/^[1-9]\d*$/;
				if(value){
					if(new RegExp(reg).test(value) == false){
						return callback(new Error('请输入正整数'));
					}
					return callback();
				}
			},
			consumptionTimeChanged(index){
        let thisAddition = this.additions[index];
        if(thisAddition.consumptionTime > Date.now()){
          thisAddition.consumptionTime = Date.now();
          this.$message.error('消费时间不能晚于当前时间');
        }
      },
			resetSearch() {
				this.$refs['searchForm'].resetFields();
				this.userInfo = {};
			},
			cancelHandler() {
				if(this.showSearchParams) {
					this.resetPage();
				} else {
					this.$router.go(-1);
				}
			},
			gotoList() {
				this.$router.push({
					path: '/member/integralmanage/integraladditionlist'
				})
			},
			searchMember() {
				this.searching = true;
				this.userInfo = {};
				this.axios.get('/sail/member/search', {
					params: this.searchForm
				}).then(response => {
					const { status, message, data } = response;
					if(data && status === '0000') {
						this.userInfo = data;
						if(this.userInfo && this.userInfo.memberStatus == '冻结') {
							//用户被冻结，无法进行积分补录
							this.$alert('该用户已被冻结，不可进行操作', '提醒', {
			          confirmButtonText: '确定'
			        });
						}
					} else {
						this.$message.error('该用户不存在，请核对填写信息');
					}
					this.searching = false;
				}).catch(error => {
					this.searching = false;
					this.$message.error('请求失败，请稍后重试');
				});
			},
			changePage(newPage) {
				this.searchShopParams.pageIndex = newPage;
				this.searchMember();
			},
			deleteAdditionLine(rowIndex) {
				this.additions.splice(rowIndex, 1);
			},
			addAdditionLine() {
				this.additions.push({
					storeId: '',
					storeName: '',
					basicFormatId: '',
					consumptionTime: '',
					amount: '',
					serialNo: '',
					transactionNo: '',
					point: '',
					comments: ''
				});
			},
			resetAdditionLine(rowIndex) {
				let thisAddition = this.additions[rowIndex];
				for(let i = 0; i < 7; i++) {
					this.$refs['addForm_' + rowIndex + '_' + i].resetFields();
				}
				thisAddition.storeId = '';
				thisAddition.basicFormatId = '';
			},
			calculateIntegral(row, rowIndex) {
				this.additions[rowIndex].point = '';
				if(row.amount == '' ) return;

				if(row.basicFormatId == '') {
					this.$message.error('请先选择商铺信息');
					return;
				}
				this.axios.get('/sail/point/right/points', {
					params: {
						memberId: JSON.parse(JSON.stringify(this.userInfo.memberCode)),
						amount: row.amount,
						basicFormatId: JSON.parse(JSON.stringify(row.basicFormatId))
					}
				}).then(response => {
					const { status, message, data } = response;
					if(status == '0000') {
						this.additions[rowIndex].point = data;
					}else if(status == '0400'){
						this.$message.error(message);
					}
				}).catch(error => {
					this.$message.error('计算积分失败');
				})
			},
			showShopDialog(rowIndex) {
				this.shopDialogVisible = true;
				this.additionLineIndex = rowIndex;
			},
			searchParamChange() {
				if(this.searchShopParam == '') return;
				this.searchShopParams.codeOrName = this.searchShopParam;
				this.axios.get('/sail/basic/store/codename', {
					params: this.searchShopParams
				}).then(response => {
					const { status, message, data, _metadata } = response;
					if(status == '0000') {
						this.searchedShops = data;
						this.shopCount = _metadata.totalCount;
					} else {
						this.$message.error(message);
					}
				}).catch(error => {
					this.$message.error('查询商铺信息失败');
				});
			},
			selectShopHandler() {
				if(this.selectedShop) {
					const { additions, additionLineIndex, selectedShop } = this;
					this.additions[additionLineIndex].storeId = selectedShop.code;
					this.additions[additionLineIndex].storeName = selectedShop.name;
					this.additions[additionLineIndex].basicFormatId = selectedShop.formatCode;
					this.shopDialogVisible = false;
				} else {
					this.$message.error('请搜索选择商家');
				}
			},
			selectShopChange(currentRow, oldRow) {
				this.selectedShop = currentRow;
			},
			closeShopDialog() {
				this.searchShopParam = '';
				this.searchedShops = [];
				this.selectedShop = null;
				this.additionLineIndex = null;
			},
			submitAdditions() {
				let validFlag = true;

				for(let i = 0; i < this.additions.length; i++) {
					for(let j = 0; j < 7; j++) {
						this.$refs['addForm_' + i + '_' + j].validate(valid => {
		          if (!valid) {
		            validFlag = false;
		          }
		        });
					}
				}

				if(!validFlag) {
					this.$message.error('信息填写不完整，无法提交');
				} else {
					this.additions.forEach(v => {
						v.memberId = this.userInfo.memberCode;
					});
					this.submiting = true;

					this.axios.post('/sail/point/addmembertrade',
						JSON.stringify({ memberTradeParams: this.additions })
					).then(response => {
							const { status, message, data } = response;
							if(status === '0000') {
								if(this.showSearchParams) {
									this.resetPage();
								} else {
									// this.$router.go(-1);
									this.gotoList();
								}
								this.$message.success(message);
							} else {
								this.$message.error(message);
							}
							this.submiting = false;
						}).catch(error => {
							console.log(error)
							this.$message.error('保存失败');
							this.submiting = false;
						})
				}
			},
			resetPage() {
				this.searchForm = {
					memberCode: '',
					mobile: ''
				};

				this.additions = [{
					storeId: '',
					storeName: '',
					basicFormatId: '',
					consumptionTime: '',
					amount: '',
					point: '',
					serialNo: '',
					transactionNo: '',
					comments: ''
				}];
				this.resetAdditionLine(0);
				this.searchShopParams = {
					code: '',
					name: '',
					status: 1,
					pageSize: 20,
					pageIndex: 1
				};
				this.userInfo = {};
				this.searchShopParam = '';
				this.searchedShops = [];
				this.selectedShop = null;
				this.shopCount = 0;
			}
		},
		mounted() {
			const memberCode = this.$route.query.memberCode;
			if(memberCode) {
				this.searchForm.memberCode = memberCode;
				this.searchMember();
			} else {
				this.showSearchParams = true;
			}
		}
	}
</script>

<style>

	.member-info {
		font-size: 14px;
	}
	.status-container {
		position: absolute;
		left: 50%;
		top: -25px;
		margin-left: -100px;
		width: 200px;
		height: 50px;
		line-height: 50px;
		text-align: center;
		color: #fff;
		font-size: 18px;
		background-color: #b5b6b6;
	}
	.status-container.danger {
		background-color: #ec000f;
	}
	.status-container.success {
		background-color: #009e4d
	}
	.integral-addition-btn{
		padding: 10px 25px;
	}
	.integral-addition-name{
		padding-left: 25px;
	}
	.integral-addition-phone{
		padding-left: 20px;
	}
	.integral-addition-body{
		background-color: white;
	    border-radius: 6px;
	    padding: 25px 31px;
	    margin-bottom: 10px;
	    zoom: 1;
	    padding-bottom: 100px;
	}
	.integral-addition-submit{
		margin-right: 20px;
		padding:10px 50px;
	}
	.integral-addition-cancel{
		width: 150px;
		background-color:#99A9BF;
		border: transparent;
		color:white;
		padding:10px 50px;
		text-align: center;
	}
	.integral-addition-cancel:hover{
		color:white;
		background-color:#A9B2BE;
	}
	.integral-addition-member .el-form-item{
		margin-bottom: 0;
	}
	.integral-addition-memberID{
		padding-left:14px;
	}
</style>
