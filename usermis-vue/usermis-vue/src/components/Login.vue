<template>
  <div class="container">
    <div class="bg-primary"  style="width:100%; height: 70px;padding-top: 10px;">
      <h2 align="center">用户登录</h2>
    </div>
    <br>
    <br>
    <form  role="form">
      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">用户名</label>
        <div class="col-sm-4 col-md-4">
          <input type="text" class="form-control"
                 placeholder="请输入您的用户名"
                 v-model="loginForm.uname">
        </div>
      </div>

      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">密码</label>
        <div class="col-sm-4 col-md-4">
          <input type="password" class="form-control"
                 placeholder="请输入您的密码" v-model="loginForm.upwd" >
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="button" class="btn btn-success" @click="login"  :disabled="isDisable" >登录</button>
          <button type="reset" class="btn btn-primary" >重置</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
  export default {
    name: 'Login',
    data () {
      return {
        isDisable:false,
        loginForm: {
          uname: '',
          upwd: ''
        }
      }
    },
    methods: {
      login () {
        this.isDisable = true;
        var formData = JSON.stringify(this.loginForm);
        let config = {
          headers:{'Content-Type':'application/json; charset=UTF-8'}
        };
        this.$axios
          .post('/login', formData, config)//直接提交表单
          .then(successResponse => {
            if (successResponse.data === "ok") {
              alert("登录成功")
              let path = this.$route.query.redirect
              this.$router.replace({path: path === '/' || path === undefined ? '/main': path})
              this.$store.commit('changeLogin',this.loginForm.uname)
            }else {
              alert("用户名或密码错误！")
              this.isDisable = false
            }
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
