// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'

//设置反向代理，前端请求默认发送到 http://localhost:8443/usermis
let axios = require('axios')//使用 axios 来完成 ajax 请求。
//全局注册，之后可在其他组件中通过 this.$axios 发送数据
axios.defaults.baseURL = 'http://localhost:8443/usermis'
//前端发送跨域请求时默认是不会携带cookie的，前端使用axios.defaults.withCredentials=true
//后端使用res.setHeader("Access-Control-Allow-Credentials","true");
//axios.defaults.withCredentials=true
Vue.prototype.$axios = axios
Vue.config.productionTip = false
// 全局前置钩子函数：router.beforeEach()，它的作用就是在每次路由切换时调用
// 这个钩子方法接收三个参数：
// to: Route: 即将要进入的目标的路由对象
// from: Route: 当前导航正要离开的路由
// next: Function: 函数结束后执行
router.beforeEach((to, from, next) => {
  // 如果路由需要验证
  if (to.matched.some(m=>m.meta.auth)) {
    // 对路由进行验证
    if (store.state.isLogin == '0') {
      alert("您没有登录，无权访问！")
      // 未登录则跳转到登陆界面，query:{ redirect: to.fullPath} 表示把当前路由信息传递过去方便登录后跳转回来：
      next({
        path: 'login',
        query:{ redirect: to.fullPath}
      })
    } else {  // 已经登录
      next()  // 正常跳转到设置好的页面
    }
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,  // 使用 store
  components: { App },
  template: '<App/>'
})
