<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 70%">
            <el-table-column
                    fixed
                    prop="id"
                    label="Id"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="Name"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="Email"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="passwd"
                    label="Password"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="Operation"
                    width="120">
                <template slot-scope="scope">
                    <!-- Form -->
                    <el-button type="text" @click="edit(scope.row)" size="small">Modify</el-button>
                    <el-popconfirm
                            confirmButtonText='Yes'
                            @onConfirm="del(scope.row)"
                            cancelButtonText='No'
                            icon="el-icon-info"
                            iconColor="red"
                            title="Delete this Account?">
                        <el-button type="text" slot="reference" size="small">Delete</el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                page-size="5"
                :total="totalPage"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            edit(row) {
                this.$router.push({
                    path: '/UserUpdate',
                    query:{
                        id: row.id
                    }
                })
            },
            del(row){
                const _this = this
                axios.post('http://localhost:8181/user/delete/'+row.id).then(function (resp) {
                    console.log(resp)
                    if (resp.data == "success"){
                        _this.$message('Delete Success!')
                    }else {
                        _this.$message('Modified Failure!');
                    }
                    setTimeout(function () {
                        window.location.reload();
                    }, 1000)
                })

            },
            page(currentpage){
                const _this = this
                axios.get('http://localhost:8181/user/findAll/'+currentpage+'/5').then(function (resp) {
                    console.log(resp)
                    _this.tableData = resp.data.content
                    _this.totalPage = resp.data.totalElements
                })            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/user/findAll/1/5').then(function (resp) {
                console.log(resp)
                _this.tableData = resp.data.content
                _this.totalPage = resp.data.totalElements
            })
        },
        data() {
            return {
                totalPage: null,
                tableData: null
            }
        }
    }
</script>