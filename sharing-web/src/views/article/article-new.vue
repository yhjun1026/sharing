<template>
  <div v-title="'物品管理'" class="new-gift-box ffan-style">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <i class="el-icon-edit"></i>&nbsp;&nbsp;
        <span>物品新增</span>
      </div>
      <div class="content-wrap">
        <el-form :inline="true" ref="searchForm" :model="searchForm" :rules="rules" style="padding-left:20px">
          <div>
            <el-form-item class="readonly-item" v-if="isEdit" label="物品编号:" prop="id">
              <template>{{searchForm.id}}</template>
            </el-form-item>
          </div>
          <div>
            <el-form-item class="readonly-item" v-if="isEdit" label="创建时间:" prop="createTime">
              <template>
                <div>{{searchForm.createTime | formatDateTime}}</div>
              </template>
            </el-form-item>
          </div>
          <!--<el-form-item label="所属广场:" prop="orgCode">-->
            <!--<el-select v-if="orgCodeSquare==false" :disabled="isEdit" size="small" v-model="searchForm.orgCode"-->
                       <!--placeholder="不限" style="width:460px;">-->
              <!--<el-option :label="item.orgName" :value="item.orgCode" v-for="(item, index) in square"-->
                         <!--:key="index"></el-option>-->
            <!--</el-select>-->
            <!--<el-form-item v-else-if="orgCodeSquare==true" style="width:210px;">{{squareName}}</el-form-item>-->
          <!--</el-form-item>-->
          <div>
            <el-form-item label="物品名称:" prop="name">
              <el-input :disabled="isEdit" type="textarea" resize="none" :rows="2" placeholder="请输入物品名称"
                        v-model="searchForm.name"
                        style="width:460px;"></el-input>
              <div style="z-index: 100;margin-left: 90%;margin-top: -35px;color:  #e6e6e6">{{edit}}</div>
            </el-form-item>
          </div>
          <el-form-item label="总库存:" prop="quantity">
            <el-input v-model="searchForm.quantity" :disabled="isEdit" placeholder="0" style="width:211px;"></el-input>
          </el-form-item>
          <div>
            <el-form-item v-if="isEdit" label="剩余库存:" prop="currentQuantity">
              <el-input v-model="searchForm.currentQuantity" placeholder="0" style="width:211px;"></el-input>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="单价:" prop="price">
              <el-input v-model="searchForm.price" placeholder="0" style="width:211px;"></el-input>
              <span class="yuan">元</span>
            </el-form-item>
            <el-form-item label="规格:" prop="unit" class="left-label">
            <el-select v-if="orgCodeSquare==false" :disabled="isEdit" size="small" v-model="searchForm.unit"
            placeholder="件" style="width:211px;">
            <el-option :label="item.unitName" :value="item.unitCode" v-for="(item, index) in unit"
            :key="index"></el-option>
            </el-select>
            <el-form-item v-else-if="orgCodeSquare==true" style="width:210px;">{{squareName}}</el-form-item>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="成本价格:" prop="costPrice">
              <el-input v-model="searchForm.costPrice" placeholder="0" style="width:211px;"></el-input>
              <span class="yuan">元</span>
            </el-form-item>
            <el-form-item label="租用价格:" prop="rentPrice" class="left-label">
              <el-input v-model="searchForm.rentPrice" placeholder="0" style="width:211px;"></el-input>
              <span class="yuan">元</span>
            </el-form-item>
          </div>

          <!--<div>-->
            <!--<el-form-item label="兑换方式:" prop="exchangeModes">-->
              <!--<el-checkbox-group v-model="searchForm.exchangeModes">-->
                <!--<el-checkbox label="GIVE" @click="">赠送</el-checkbox>-->
                <!--<el-form-item prop="point" :class="pointClass">-->
                  <!--<el-checkbox ref="pointEl" label="EXCHANGE" v-on:change="enableVal">以-->
                    <!--<el-input :disabled="inputDisabled" v-model="searchForm.point" placeholder=""-->
                              <!--style="width:100px;"></el-input>-->
                    <!--积分兑换-->
                  <!--</el-checkbox>-->
                <!--</el-form-item>-->
              <!--</el-checkbox-group>-->
            <!--</el-form-item>-->
          <!--</div>-->

          <div>
            <el-form-item label="物品图片:" prop="picture">
              <el-row :gutter="20">
                <el-col :span="12">
                  <el-upload
                    class="avatar-uploader"
                    action="/sail/images"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                    <img v-model="searchForm.picture" v-if="searchForm.picture" :src="searchForm.picture" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                  </el-upload>

                </el-col>
                <el-col :span="12">
                  <div class="grid-right ">
                    <p>上传须知：</p>
                    <p>1.格式：JPG、JPEG、PNG</p>
                    <p>2.图片大小：不超过5M</p>
                  </div>
                </el-col>
              </el-row>
            </el-form-item>
          </div>
        </el-form>
        <div slot="my-dialog-footer" style="text-align:center;">
          <el-button type="primary" @click="submit('searchForm')">保存</el-button>
          <el-button @click="cancel('searchForm')">取 消</el-button>
        </div>
      </div>
    </el-card>

  </div>
</template>
<script>
  export default {
    name: "articles",
    data(){
      var checkRemark = (rule, value, callback) => {
        this.edit = value.length + '/50';
        if (value.length >= 51) {
          callback(new Error('请输入50字以内的礼品名称'));
        } else {
          callback();
        }
      };

//      const selfInst = this;
//      const validImage = (rules, value, callback) => {
//        if (selfInst.searchForm.picture) {
//          callback();
//        } else {
//          callback(new Error("请添加图片"));
//        }
//      };
      return {
        changed:0,
        type: '',
        orgCodeSquare: false,
        squareName: "",
        checkList: ['', ''],
        checked: true,
        defaultData: {
          //quantity: 0,
          currentQuantity: 0
        },
        unit: [],
        searchForm: {
          quantity: 0,
          //总库存
          currentQuantity: 0,
          //当前库存
          orgCode: "",
          //广场编号
          code: '',
          //物品代码
          name: '',
          //物品名字
          price: 0,
          //物品价格
          costPrice: 0,
          //成本价格
          rentPrice: 0,
          //租用价格
          unit: '',
          //规格
          picture: '',
          //物品图片
          plazaName: '',
           //广场名字
          remark: ''
          //字数限制
        },
        edit: "0/50",
        inputDisabled: true,
        rules: {
          orgCode: [
            {required: true, message: '请选择活动区域', trigger: 'change'}
          ],
          quantity: [
            {required: true, message: '请输入总库存'},
            {pattern: /^(?:0|[1-9]{1}\d{0,5})$/, message: '请输入1~999999之间的整数'}
          ],
          currentQuantity: [
            {pattern: /^(?:0|[1-9]{1}\d{0,5})$/, message: '请输入1~999999之间的整数'}
          ],
          name: [
            {required: true, message: '请输入物品名称', trigger: 'blur'},
            {validator: checkRemark, trigger: 'change,blur'}
          ],
//          picture: [
//            {required: true, validator: validImage}
//          ],
          unit:[
            {
              required: true,
              message: '请选择规格', trigger: 'change'
            }
          ],
          price: [
            {
              required: true,
              pattern: /^(?:0|[1-9]{1}\d{0,5})(\.\d{0,2})?$/,
              message: '请输入0~999999之间的数值',
              trigger: 'change,blur'
            }
          ],
          costPrice: [
            {
              required: true,
              pattern: /^(?:0|[1-9]{1}\d{0,5})(\.\d{0,2})?$/,
              message: '请输入0~999999之间的数值',
              trigger: 'change,blur'
            }
          ],
          rentPrice: [
            {
              required: true,
              pattern: /^(?:0|[1-9]{1}\d{0,5})(\.\d{0,2})?$/,
              message: '请输入0~999999之间的数值',
              trigger: 'change,blur'
            }
          ]
        },
        square: [],
        //判断是编辑还是新建
        isEdit: false,
        pointClass: "point-el"
      }
    },
    methods: {
      enableVal(ev){
        let pointClass = "", inputStatus = true;
        if (ev.currentTarget.checked) {
          pointClass = " point-el-vali";
          inputStatus = false;
        }
        this.inputDisabled = inputStatus;
        this.pointClass = "point-el" + pointClass;
        this.searchForm.point = "";
      },
      submit(searchForm){
        this.$refs[searchForm].validate((vaild) => {
          if (vaild) {
            this.changed = 1;
            this.save(() => {
              if (!this.$route.query.isShowTip) {
              this.$message({
                message: '物品信息已更新',
                type: 'success'
              });
            } else {
              this.$confirm('成功新增物品', '', {
                cancelButtonText: '取消',
                confirmButtonText: '继续添加',
                type: 'success',
                confirmButtonClass: 'new-gift-confirmButtonClass',
                cancelButtonClass: 'new-gift-cancelButtonClass'
              }).then((action) => {
                this.$router.push({
                name: "editgift"
              })
            }).catch(() => {

              });
            }
          });

          } else {
            return false;
      }
      });
      },
      handleAvatarSuccess(res, file) {
        this.searchForm.picture = res.data.url;
      },
      beforeAvatarUpload(file) {
        const isPic = (file.type === 'image/jpeg' || file.type === 'image/png');
        const isLt5M = file.size / 1024 / 1024 < 5;
        if (!isPic) {
          this.$message.error('上传图片只能是 JPG/PNG 格式!');
        }
        if (!isLt5M) {
          this.$message.error('上传图片大小不能超过 5MB!');
        }
        return isPic && isLt5M;
      },
      save(callback){
        let fetchUrl = "/sail/gifts";
        if (this.isEdit) {
          fetchUrl = "/sail/gifts/put/byId";
          //总库存是不参与更新库存的计算，由当前库存的增量进行判断
          //this.searchForm.quantity = antity - this.defaultData.quantity;
          this.searchForm.currentQuantity = this.searchForm.currentQuantity - this.defaultData.currentQuantity;
        }
        const searchParams = filter.dealParams(this.searchForm);

        if (!searchParams.point) {
          if (!this.inputDisabled) {
            this.$message.error('请输入兑换积分');
            return;
          }
          searchParams.point = 0;
        }

        this.axios.post(fetchUrl, searchParams)
          .then((res) => {
          const {data} = res;
        if (res.status == "0000") {
          const giftId = data.id || this.searchForm.id;
          this.$router.push({
            name: "giftDetail",
            query: {
              id: giftId,
              isShowTip: !this.isEdit
            }
          })
          callback();
        }
      });
      },
      getSquare(){
        var square = store.state.accounts.org.name;
        this.searchForm.square = square;
        this.searchForm.orgCode = store.state.accounts.org.code;
        //todo： 由于登录用户的数据里缺少组织的类型，无法判断是否是广场会员
        //todo：所以暂时使用文案来判断，612的时候需要修改这个逻辑。
        // @林家颖
        if (square.indexOf('广场') > 0) {
          this.orgCodeSquare = true;
          this.squareName = square;
          return true;
        }
      },
      getIntData() {
        if (this.getSquare()) {
          return;
        }
        this.axios.all([
          this.axios.get('sail/member/scopes', {
            params: {
              type: 2
            }
          }),
        ]).then(this.axios.spread((scopes) => {
            if (scopes.status == '0000') {
          this.square = scopes.data;
        }
      }));
      },
      cancel(){
//        this.$router.go(-1);
        this.changed = 1;
        this.$router.push({
          path: '/member/memberintegral/giftlist'
        })
      },
      getArticleData(id){
        if (!id) return;
        this.isEdit = true;
        this.inputDisabled = false;
        this.axios.get(`/goods/${id}`)
          .then((response) => {
          if (response.status == 0) {
          let data = response.data;
          this.defaultData = {
            //quantity: data.quantity,
            currentQuantity: data.currentQuantity
          };
          //由于积分默认不能为0，前端有校验，所以需要在处理下数据，将积分重置为空
          if (data.point === 0) {
            data.point = "";
          }
          this.searchForm = data;
        }
      })
      .catch(function (error) {
          console.log(error);
        });
      }
    },
    mounted(){
      this.getIntData();
      this.getArticleData(this.$route.query.id);
//      console.log(this.$route.query.type);
      this.type = this.$route.query.type;
    },
    beforeRouteLeave(to, from, next) {
      // 判断是否是退出登录
      if(to.path != '/'){
        if (this.changed <= 0) {
          this.$confirm('离开该页面后您编辑的所有数据将丢失，确定离开吗?', '提示', {
            confirmButtonText: '去意已决',
            cancelButtonText: '再想想',
            customClass: 'member-confirm-class',
            type: 'warning'
          }).then(() => {
            // 离开当前页面
            next();
        }).catch((error) => {
            // 留在当前页面
            next(false);
        });
        } else {
          next()
        }
      }else{
        next()
      }
    }
  };
</script>
<style lang="less">
  .new-gift-box {
  .grid-content {
    width: 150px;
    height: 100px;
    border: 1px solid #e6e6e6;
    position: relative;
  }
  .el-form-item__label {
    position: relative;
    width: 90px;
  }
  .el-form-item__label:before {
    position: absolute;
    left: -2px;
  }
  .left-label{
    margin-left: 1.5em;
  }
  .readonly-item {
    display: block;
  //padding-left: 10px;
  }
  .grid-right p {
    width: 170px;
    line-height: 25px;
  }
  .grid-content .icon {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-left: -7px;
    margin-top: -7px;
  }
  .yuan {
    position: absolute;
    top: 0;
    left: 213px;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #20a0ff;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .point-el {
  .el-form-item__error {
    left: 100px;
    width: 200px;
    display: none;
  }
  &.point-el-vali .el-form-item__error {
     display: block;
   }
  .el-input__inner {
    border-color: #bfcbd9;
  }
  &.point-el-vali.is-error .el-input__inner {
     border-color: #ff4949;
   }
  }

  }

  .new-gift-confirmButtonClass {
    float: left;
    margin-left: 120px !important;
  }

  .new-gift-cancelButtonClass {
    margin-right: 90px;
    /* color: #fff;
     background-color: #20a0ff;
     border-color: #20a0ff;*/
  }
</style>

