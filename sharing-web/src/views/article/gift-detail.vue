<template>
  <div class="gift-detail-box ffan-style">
    <div class="crumbs">
      <el-breadcrumb separator="">
        <el-breadcrumb-item normal>会员维护与应用</el-breadcrumb-item>
        <el-breadcrumb-item normal>礼品管理</el-breadcrumb-item>
        <el-breadcrumb-item :to="{name:'giftList'}">礼品列表</el-breadcrumb-item>
        <el-breadcrumb-item>礼品详情</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="content-wrap">
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">礼品编号：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.id}}</div>
        </el-col>
        <el-col :span="2" class="edit-btn">
          <qf-access :code="'btn_membermnt_3_1_3'">
            <el-button type="primary" @click="edit(giftList.id)" class="compile">修改</el-button>
          </qf-access>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">创建时间：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.createTime | formatDateTime}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">所属广场：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.plazaName}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">礼品名称：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.name}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">总库存：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.quantity}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">已兑：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.quantity - giftList.currentQuantity}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">剩余库存：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.currentQuantity}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">兑换方式：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{exchange}}</div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="2">
          <div class="grid-content bg-purple">零售价格：</div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple-light">{{giftList.price}}</div>
        </el-col>
      </el-row>
      <el-row>
        <div class="picture">
          <el-col :span="2">
            <div class="grid-content bg-purple">礼品图片：</div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple-light"><img v-if="giftList.picture" :src="giftList.picture"></div>
          </el-col>
        </div>
      </el-row>
      <div class="log">
        <p>操作日志：</p>
        <br>
        <el-table :data="tableData" stripe style="width: 80%">
          <el-table-column align="center" prop="createTime" label="操作时间" width="180">
            <template scope="scope">{{scope.row.createTime|formatDateTime}}</template></el-table-column>
          <el-table-column align="center" prop="operatorName" label="操作人" width="180"></el-table-column>
          <el-table-column align="left" prop="operation" label="操作内容"></el-table-column>
        </el-table>
      </div>
    </div>
    <qf-sailfooter></qf-sailfooter>
  </div>
</template>

<script>

  
  

  export default {
    components: {
     
    },
    data(){
      return {
        tableData: [{
          createTime: 1493795882000,
          name: "testGift1",
        }],
        giftList: {
          "id": "",
          "createTime": 0,
          "createUserId": "",
          "currentQuantity": 0,
          "exchangeModes": [],
          "name": "",
          "orgCode": "",
          "picture": ":",
          "plazaName": "",
          "point": 0,
          "price": 0,
          "quantity": 0,
          "remark": "",
          "status": 0,
          "tenantId": 0
        },
        exchange: "111"
      }
    },
    methods: {
      search(){

        const id = this.$route.query.id;
        this.fetch([{
          url: `/sail/gifts/${id}/byId`
        }, {
          url: `/sail/gift/logs/byId`,
          params: {
            id: id
          }
        }]).then(response => {
          const [lists, logs] = response;
          if (lists.status === "0000") {
            this.giftList = lists.data;
            this.dealData();
          }
          if (logs.status === "0000") {
            this.tableData = logs.data;
          }
        })
      },
      fetch(fetchArr){
        return new Promise((resolve, reject) => {
          let fetchObjArr = [];
          fetchArr.forEach((item) => {
            let method = item.method || "get";
            if (method === "get") {
              item.params = item.params || item.data;
            } else {
              item.data = item.data || item.params;
            }
            fetchObjArr.push(this.axios(item));
          });
          this.axios.all(fetchObjArr).then(
            this.axios.spread(function (...args) {
              resolve(args);
            })
          )
        });
      },
      dealData(){
        const exchangeModes = this.giftList.exchangeModes;
        const modes = {
          "GIVE": "赠送",
          "EXCHANGE": `以${this.giftList.point}积分兑换`
        };
        const point = this.giftList.point;
        exchangeModes.forEach(function (item, index) {
          exchangeModes[index] = modes[item];
        });
        this.exchange = exchangeModes.join('、');
      },
      edit(){
        this.$router.push({
          name: "editgift",
          query: {
            id: this.$route.query.id,
            type:'edit'
          }

        })
      },
      showAlert(){
          if(this.$route.query.isShowTip !== "true"){
              return;
          }
//        this.$confirm('成功新增礼品', '', {
//          confirmButtonText: '继续添加',
//          cancelButtonText: '不必了',
//          type: 'success'
//        }).then((action) =>{
//          this.$router.push({
//            name: "editgift"
//          })
//        }).catch(()=>{
//
//        });
      }
    },
    mounted(){
      this.search();
      this.showAlert();
    }

  }
</script>


<style lang="less">

  .gift-detail-box {
    .el-row {
      margin-bottom: 20px;
      &:last-child {
        margin-bottom: 0;
      }
    }
    .compile{
      position:absolute;
      right:0;
    }
    .bg-purple {
      text-align: right;
    }
    .bg-purple-light img{
      width:250px;
    }
    .editor-btn {
      position: absolute;
      right: 0px;
      .el-button {
        font-size: 16px;
        width: 80px;
      }
    }
    .grid-content {
      border-radius: 4px;
      /*min-height: 36px;*/
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
    .log {
      margin-top: 50px;
    }
    .content-wrap {
      position: relative;
    }
    .butBox {
      position: absolute;
      top: 20px;
      right: 60px;
    }
  }

</style>
