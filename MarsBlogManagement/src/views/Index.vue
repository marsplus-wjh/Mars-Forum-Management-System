<!--<template>-->
<!--    <div>-->
<!--            el-container构建整个页面框架 = div-->
<!--            <el-container style="height: 600px; border: 1px solid #eee">-->

        <!--      el-aside构建左侧菜单-->
<!--              <el-aside width="200px" style="background-color: rgb(238, 241, 246)">-->
        <!--        el-menu菜单内容-->
        <!--        <el-menu :default-openeds="['1', '3']" :default-active="'1-1'">-->
        <!--&lt;!&ndash;          default-opens 默认展开的菜单，通过菜单的index值关联 1 3打开-->
        <!--              default-active:默认选中，通过index&ndash;&gt;-->
        <!--          <el-submenu index="1">-->
        <!--&lt;!&ndash;            el-submenu可以展开的菜单，常用属性：index：菜单下表，文本类型，不是数值类型。&ndash;&gt;-->
        <!--&lt;!&ndash;            template对应el-submenu设置内容，i：设置菜单图标 el-icon-message el-icon-menu el-icon-setting&ndash;&gt;-->
        <!--            <template slot="title"><i class="el-icon-message"></i>导航一</template>-->

        <!--&lt;!&ndash;            el-menu-item：菜单的子节点，不可再展开， 常用属性：index&ndash;&gt;-->

        <!--&lt;!&ndash;            <el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;              <template slot="title">分组一</template>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="1-1">选项1</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="1-2">选项2</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-menu-item-group title="分组2">&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="1-3">选项3</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-submenu index="1-4">&ndash;&gt;-->
        <!--&lt;!&ndash;              <template slot="title">选项4</template>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="1-4-1">选项4-1</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-submenu>&ndash;&gt;-->
        <!--            <el-menu-item index="1-1">选项1</el-menu-item>-->
        <!--            <el-menu-item index="1-2">选项2</el-menu-item>-->
        <!--              <el-submenu index="1-3">-->
        <!--                  <template slot="title"><i class="el-icon-setting"></i>选项3</template>-->
        <!--                  <el-menu-item index="3-1">选项3-1</el-menu-item>-->
        <!--                  <el-menu-item index="3-2">选项3-2</el-menu-item>-->
        <!--              </el-submenu>-->
        <!--          </el-submenu>-->

        <!--&lt;!&ndash;          <el-submenu index="2">&ndash;&gt;-->
        <!--&lt;!&ndash;            <template slot="title"><i class="el-icon-menu"></i>导航二</template>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;              <template slot="title">分组一</template>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="2-1">选项1</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="2-2">选项2</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-menu-item-group title="分组2">&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="2-3">选项3</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-submenu index="2-4">&ndash;&gt;-->
        <!--&lt;!&ndash;              <template slot="title">选项4</template>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="2-4-1">选项4-1</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-submenu>&ndash;&gt;-->
        <!--&lt;!&ndash;          </el-submenu>&ndash;&gt;-->

        <!--&lt;!&ndash;          <el-submenu index="3">&ndash;&gt;-->
        <!--&lt;!&ndash;            <template slot="title"><i class="el-icon-setting"></i>导航三</template>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;              <template slot="title">分组一</template>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="3-1">选项1</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="3-2">选项2</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-menu-item-group title="分组2">&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="3-3">选项3</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-menu-item-group>&ndash;&gt;-->
        <!--&lt;!&ndash;            <el-submenu index="3-4">&ndash;&gt;-->
        <!--&lt;!&ndash;              <template slot="title">选项4</template>&ndash;&gt;-->
        <!--&lt;!&ndash;              <el-menu-item index="3-4-1">选项4-1</el-menu-item>&ndash;&gt;-->
        <!--&lt;!&ndash;            </el-submenu>&ndash;&gt;-->
        <!--&lt;!&ndash;          </el-submenu>&ndash;&gt;-->
        <!--        </el-menu>-->

<!--                  menu与router的绑定，1.el-menu标签添加router属性
                                        2.页面添加router-view标签，它是一个容器，动态渲染选择的router
                                        3.el-menu-item 添加跳转属性index就是要跳转的router-->
<!--                  <el-menu router :default-openeds="[0, 1]">-->
<!--                      <el-submenu v-for="(item, index) in $router.options.routes" :index="index">-->
<!--                          <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>-->
<!--                          <el-menu-item v-for="( item2, index2) in item.children" :index="item2.path"-->
<!--                          :class="$route.path==item2.path?'is-active':''">-->
<!--                              {{item2.name}}-->
<!--                          </el-menu-item>-->
<!--                      </el-submenu>-->
<!--                  </el-menu>-->
<!--              </el-aside>-->

<!--              <el-container>-->
<!--                <el-header style="text-align: right; font-size: 12px">-->
<!--                  <el-dropdown>-->
<!--                    <i class="el-icon-setting" style="margin-right: 15px"></i>-->
<!--                    <el-dropdown-menu slot="dropdown">-->
<!--                      <el-dropdown-item>Search</el-dropdown-item>-->
<!--                      <el-dropdown-item>Add</el-dropdown-item>-->
<!--                      <el-dropdown-item>Delete</el-dropdown-item>-->
<!--                    </el-dropdown-menu>-->
<!--                  </el-dropdown>-->
<!--                  <span>Mars</span>-->
<!--                </el-header>-->

<!--                <el-main>-->
<!--                    <router-view></router-view>-->
        <!--          <el-table :data="tableData">-->
        <!--            <el-table-column prop="date" label="日期" width="140">-->
        <!--            </el-table-column>-->
        <!--            <el-table-column prop="name" label="姓名" width="120">-->
        <!--            </el-table-column>-->
        <!--            <el-table-column prop="address" label="地址">-->
        <!--            </el-table-column>-->
        <!--          </el-table>-->
<!--                </el-main>-->
<!--              </el-container>-->
<!--            </el-container>-->
<!--    </div>-->
<!--</template>-->

<!--<script>-->
<!--    export default {-->
<!--        name: "Index"-->
<!--    }-->
<!--</script>-->

<!--<style>-->
<!--    .el-header {-->
<!--        background-color: #B3C0D1;-->
<!--        color: #333;-->
<!--        line-height: 60px;-->
<!--    }-->

<!--    .el-aside {-->
<!--        color: #333;-->
<!--    }-->
<!--</style>-->

<template>
    <router-view></router-view>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>