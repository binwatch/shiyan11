<template>
  <div class="container">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h3 class="panel-title">用户列表</h3>
      </div>
      <div class="panel-body">
        <div class="table table-responsive">
          <table class="table table-bordered table-hover">
            <tbody class="text-center">
            <tr>
              <th>id</th>
              <th>uname</th>
              <th>upwd</th>
            </tr>
            <tr v-for="u in users">
              <td>{{u.id}}</td>
              <!--id是结果集的列名  -->
              <td>{{u.uname}}</td>
              <td>{{u.upwd}}</td>
            </tr>
            <tr>
              <td colspan="3" align="right">
                <ul class="pagination">
                  <li><a>第{{currentPage}}页
                  </a></li>
                  <li><a>共{{totalPage}}</a></li>
                  <li>
											<span v-if="currentPage != 1"> <a @click="getUp" style="cursor: pointer">上一页</a>
											</span>
                    <span v-if="currentPage != totalPage"> <a @click="getDown" style="cursor: pointer">下一页</a>
											</span>
                  </li>
                </ul>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'Main',
    data () {
      return {
        users: [],//保存数据
        currentPage: 0,
        totalPage: 0
      }
    },
    //created:在模板渲染成html前调用，即通常初始化某些属性值，然后再渲染成视图。
    //mounted:在模板渲染成html后调用，通常是初始化页面完成后，再对html的dom节点进行一些//需要的操作。
    created: function () {
      this.loadUsers()
    },
    methods: {
      loadUsers() {
        let _this = this
        this.$axios
          .get('/selectAllUserByPage?currentPage=1')
          .then(successResponse => {
              _this.users = successResponse.data.allUser
              _this.currentPage = successResponse.data.currentPage
              _this.totalPage = successResponse.data.totalPage
          })
          .catch(failResponse => {
            alert("响应异常")
          })
      },
      getUp(){
        let _this = this
        this.$axios
          .get('/selectAllUserByPage?currentPage=' + (_this.currentPage - 1))
          .then(successResponse => {
            _this.users = successResponse.data.allUser
            _this.currentPage = successResponse.data.currentPage
            _this.totalPage = successResponse.data.totalPage
          })
          .catch(failResponse => {
            alert("响应异常")
          })
      },
      getDown(){
        let _this = this
        this.$axios
          .get('/selectAllUserByPage?currentPage=' + (_this.currentPage + 1))
          .then(successResponse => {
            _this.users = successResponse.data.allUser
            _this.currentPage = successResponse.data.currentPage
            _this.totalPage = successResponse.data.totalPage
          })
          .catch(failResponse => {
            alert("响应异常")
          })
      }
    }
  }
</script>

<style scoped>

</style>
