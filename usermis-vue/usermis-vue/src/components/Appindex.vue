<template>
  <div class="container-fruid">
    <div class="navbar navbar-default navbar-fixed-top" role="navigation"
         style="padding-left: 30px;">
      <div class="navbar-header">
        <span class="navbar-brand">201900020169 吴晓宇 作业五 鲲鹏云上应用高可用部署实验</span>
      </div>
      <ul class="nav navbar-nav">
        <li><router-link to="/register" :exact="true">注册</router-link> </li>
        <li><router-link to="/login" :exact="true">登陆</router-link> </li>
        <li><a href="##">后台</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right" style="padding-right: 30px;">
        <li><a href="##">个人信息</a></li>
        <li><a href="##">我的购物车</a></li>
        <li><a href="##">我的订单</a></li>
        <li class="dropdown"><a href="##" data-toggle="dropdown"
                                class="dropdown-toggle">关于我们<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="##">联系我们</a></li>
            <li><a href="##">投诉建议</a></li>
          </ul></li>
      </ul>
    </div>

    <!-- ************************************************** -->
    <div id="carousel-example-generic" class="carousel slide"
         data-ride="carousel" style="margin-top: -20px;">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0"
            class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="../assets/images/slider20180323.jpg" alt="1">
          <div class="carousel-caption">fgfdgdgdfgfd</div>
        </div>
        <div class="item">
          <img src="../assets/images/banner2017032901.jpg" alt="2">
          <div class="carousel-caption">dgfdfgfd</div>
        </div>
        <div class="item">
          <img src="../assets/images/slider20180122.jpg" alt="3">
          <div class="carousel-caption">dgfdgdfgfd</div>
        </div>
        <div class="item">
          <img src="../assets/images/banner2017032902.jpg" alt="4">
          <div class="carousel-caption">...</div>
        </div>
      </div>

      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic"
         role="button" data-slide="prev"> <span
        class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a> <a class="right carousel-control" href="#carousel-example-generic"
              role="button" data-slide="next"> <span
      class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
    </div>



    <!-- *************************************** -->
    <div class="navbar navbar-default " role="navigation">
      <ul class="nav navbar-nav" style="padding-left: 50px;">
        <li class="active"><a href="##">网站首页</a></li>
        <li><a href="##">玫瑰花</a></li>
        <li><a href="##">郁金香</a></li>
        <li><a href="##">康乃馨</a></li>
        <li><a href="##">紫罗兰</a></li>
      </ul>
      <form action="##" class="navbar-form navbar-right"
            style="padding-right: 50px;">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="请输入关键词" />
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
    </div>
  </div>
</template>
<script>
    export default {
        name: ""
    }
</script>
<style scoped>
  .carousel {
    height: 200px;
    background-color: #000;
  }

  .carousel .item {
    height: 200px;
    background-color: #000;
  }

  .carousel img {
    width: 100%;
  }
</style>
