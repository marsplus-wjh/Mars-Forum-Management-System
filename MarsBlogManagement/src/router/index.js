import Vue from 'vue'
import VueRouter from 'vue-router'
import UserManage from '../views/UserManage.vue'
import AddUser from '../views/AddUser.vue'
import UserUpdate from '../views/UserUpdate.vue'
import ArticleUpdate from '../views/ArticleUpdate.vue'
import CommentUpdate from '../views/CommentUpdate.vue'
import ArticleManagement from '../views/ArticleManagement.vue'
import AddArticle from '../views/AddArticle.vue'
import CommentManagement from '../views/CommentManagement.vue'
import AddComment from '../views/AddComment.vue'
import Index from "../views/Index"

// 通过router动态搭建左侧菜单
// 导航1
//   页面1
//   页面2
// 导航2
//   页面3
//   页面4
Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'User Management',
    component: Index,
    show:true,
    redirect: '/UserManage',
    children:[
      {
        path: '/UserManage',
        name: 'Users',
        component: UserManage
      },
      {
        path: '/AddUser',
        name: 'Add User',
        component: AddUser
      },
      ]
  },
    {
      path: '/',
      name: 'Article Management',
      component: Index,
      show:true,
      redirect: '/ArticleManagement',
      children:[
        {
          path: '/ArticleManagement',
          name: 'Articles',
          component: ArticleManagement
        },
        {
          path: '/AddArticle',
          name: 'Add Article',
          component: AddArticle
        }
      ]
    },
    {
      path: '/',
      name: 'Comment Management',
      component: Index,
      show:true,
      redirect: '/CommentManagement',
      children:[
        {
          path: '/CommentManagement',
          name: 'Comments',
          component: CommentManagement
        },
        {
          path: '/AddComment',
          name: 'Add Comment',
          component: AddComment
        }
      ]
    },
    {
      path: '/UserUpdate',
      name: 'User Update',
      show:false,
      component: UserUpdate
    },
    {
      path: '/ArticleUpdate',
      name: 'Article Update',
      show:false,
      component: ArticleUpdate
    },
    {
      path: '/commentUpdate',
      name: 'Comment Update',
      show:false,
      component: CommentUpdate
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
