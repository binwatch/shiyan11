<template>
  <div class="container">
    <div class="bg-primary"  style="width:100%; height: 70px;padding-top: 10px;">
      <h2 align="center">用户注册</h2>
    </div>
    <br>
    <br>
    <form role="form">
      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">用户名</label>
        <div class="col-sm-4 col-md-4">
          <input type="text" class="form-control"
                 placeholder="请输入您的用户名"
                 v-model="registerForm.uname">
        </div>
      </div>

      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">性别</label>
        <div class="col-sm-4 col-md-4 radio">
          <label>
            <input type="radio"  name="sex" value="male" checked="checked">男
          </label>
          <label>
            <input type="radio"  name="sex" value="female">女
          </label>
        </div>
      </div>

      <div class="form-group has-error">
        <label class="col-sm-2 col-md-2 control-label">所在地</label>
        <div class="col-sm-4 col-md-4">
          <select class="form-control" name="address">
            <option value="">请选择所在地</option>
            <option value="大连1">大连1</option>
            <option value="大连2">大连2</option>
            <option value="大连3">大连3</option>
            <option value="大连4">大连5</option>
            <option value="大连6">大连6</option>
          </select>
        </div>
      </div>

      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">爱好</label>
        <div class="col-sm-4 col-md-4 checkbox">
          <label><input type="checkbox" value="篮球" name="loves">篮球</label>
          <label><input type="checkbox" value="足球" name="loves">足球</label>
          <label><input type="checkbox" value="羽毛球" name="loves">羽毛球</label>
          <label><input type="checkbox" value="游戏" name="loves">游戏</label>
        </div>
      </div>

      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">你的靓照</label>
        <div class="col-sm-4 col-md-4">
          <input type="file"  class="form-control" name="myfile"/>
        </div>
      </div>

      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">个人描述</label>
        <div class="col-sm-4 col-md-4">
          <textarea rows="5" class="form-control"></textarea>
        </div>
      </div>


      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">密码</label>
        <div class="col-sm-4 col-md-4">
          <input type="password" class="form-control"
                 placeholder="请输入您的密码"
                 v-model="registerForm.upwd"
          >
        </div>
      </div>

      <div class="form-group has-success">
        <label class="col-sm-2 col-md-2 control-label">确认密码</label>
        <div class="col-sm-4 col-md-4">
          <input type="password" class="form-control"
                 placeholder="请输入您的密码"
                 v-model="registerForm.reupwd">
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="button" class="btn btn-success"   @click="register" :disabled="isDisable" >注册</button>
          <button type="reset" class="btn btn-primary" >重置</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
    export default {
      name: "Register",
      data () {
        return {
          isDisable:false,
          registerForm: {
            uname: '',
            upwd: '',
            reupwd: ''
          }
        }
      },
      methods: {
        register () {
          this.isDisable = true;
          if(this.registerForm.upwd != this.registerForm.reupwd) {
            alert("两次密码不一致，重新输入！");
            this.isDisable = false
            return false;
          }
          this.$axios
            .post('/register', {
              uname: this.registerForm.uname,
              upwd: this.registerForm.upwd
            })
            .then(successResponse => {
              if (successResponse.data === "no") {
                alert("注册失败！")
                this.isDisable = false
              }else{
                alert("注册成功！")
                this.$router.replace({path: '/login'})
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
