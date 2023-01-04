import Vue from 'vue'
import Router from 'vue-router'
import Appindex from '@/components/Appindex'
import Login from '@/components/Login'
import Register from '@/components/Register'
import Main from '@/components/Main'

Vue.use(Router)

export default new Router({
  //将路由从默认的 hash 模式切换为 histroy 模式，运行项目，访问不加 # 号
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Appindex',
      component: Appindex
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/main',
      name: 'Main',
      component: Main
      //meta: {auth:true} // 需要登录权限验证
    }
  ]
})
