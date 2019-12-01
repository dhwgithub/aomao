//注册表单验证
$(function () {
    $('#addUserForm').bootstrapValidator({
    	message: 'This value is not valid',
    	feedbackIcons: {
    			  valid: 'glyphicon glyphicon-ok',
    			  invalid: 'glyphicon glyphicon-remove',
    			  validating: 'glyphicon glyphicon-refresh'
    	},
        fields: {
            	register_uname: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },stringLength: {
	                        min: 2,
	                        max: 12,
	                        message: '2-12位字母或数字'
	                    }
                    }
                },
                register_pwd: {
                	validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },stringLength: {
	                        min: 6,
	                        max: 18,
	                        message: '6-18位字母或数字'
	                    },identical: {
	                        field: 'register_repwd',
	                        message: '请保持密码一致'
	                    }
	                }
                },
                register_repwd: {
                	validators: {
	                    notEmpty: {
	                        message: '请再次输入密码'
	                    },stringLength: {
	                        min: 6,
	                        max: 18,
	                        message: '6-18位字母或数字'
	                    },identical: {
	                        field: 'register_pwd',
	                        message: '请保持密码一致'
	                    }
	                }
                },
                register_email: {
                    validators: {
	                    notEmpty: {
	                        message: '邮箱不能为空'
	                    },
	                    emailAddress: {
	                        message: '非法邮箱格式'
	                    }
	                }
                }
            }
        });
    });
    //登录表单验证
    $(function() {
    	$("#loginForm").bootstrapValidator({
    		message: 'This value is not valid',
    		feedbackIcons: {
    				valid: 'glyphicon glyphicon-ok',
    				invalid: 'glyphicon glyphicon-remove',
    				validating: 'glyphicon glyphicon-refresh'
    		},
            fields: {
            	login_username: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },stringLength: {
	                        min: 2,
	                        max: 12,
	                        message: '2-12位字母或数字'
	                    }
                    }
                },
                login_pwd: {
                	validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },stringLength: {
	                        min: 6,
	                        max: 18,
	                        message: '6-18位字母或数字'
	                    }
	                }
                }
            }
    	});
    });
