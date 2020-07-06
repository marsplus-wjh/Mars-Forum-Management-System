<template>
    <div style="width: 50%">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="Name" prop="name">
                <el-input v-model.number="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="Email" prop="email">
                <el-input v-model.number="ruleForm.email"></el-input>
            </el-form-item>
            <el-form-item label="Password" prop="passwd">
                <el-input type="password" v-model="ruleForm.passwd" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Confirm" prop="checkPass">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">Submit</el-button>
                <el-button @click="resetForm('ruleForm')">Reset</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            var checkName = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('Name Cannot Empty'));
                }
                setTimeout(() => {
                    callback();
                }, 500);
            };
            var checkEmail = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('Email Cannot Empty'));
                }
                setTimeout(() => {
                    if (value.indexOf('@') === -1 && value.indexOf('.') === -1) {
                        callback(new Error('Incorrect Email Format'));
                    } else {
                        callback();
                    }
                }, 500);
            };
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('Password Cannot Empty'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('Confirmed Password Cannot Empty'));
                } else if (value !== this.ruleForm.passwd) {
                    callback(new Error('Not Identical!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    name: '',
                    email: '',
                    passwd: ''
                },
                rules: {
                    name: [
                        //blur失去焦点事件，可以在rules中设置校验规则
                        { validator: checkName, trigger: 'blur' }
                    ],
                    email: [
                        { validator: checkEmail, trigger: 'blur' }
                    ],
                    passwd: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/user/save', _this.ruleForm).then(function (resp) {
                            if (resp.data == "success"){
                                _this.$message('Add User Success!');
                                _this.$router.push('/UserManage')
                                _this.resetForm(_this.ruleForm)
                            }else {
                                _this.$message('Add User Failure!');
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>