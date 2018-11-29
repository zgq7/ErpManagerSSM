$(document).ready(function () {
    /**用户登录
     */
    $("button.login").click(
        function () {
            var username = $("input.usernameL").val();
            var password = $("input.passwordL").val();
            if (username === "" || username === null) {
                alert("账号未输入");
                return false;
            } else if (password === "" || password === null) {
                alert("密码未输入");
                return false;
            }
            return true;
        });

    /**显示注册界面
     */
    $("button.register").click(function () {
        var dad = $("#register");
        dad.show();
        $("#div01").hide();
        dad.children(".username").val("");
        dad.children(".name").val("");
        dad.children(".password").val("");
        dad.children('.mobile').val("");
    });

    /**会员信息注册，注册前检查输入是否有误
     */
    $("button.postCus").click(function () {
        var dad = $("#register");
        var customer = {};
        customer.cardNo = dad.children(".username").val();
        customer.name = dad.children(".name").val();
        customer.password = dad.children(".password").val();
        customer.mobile = dad.children(".mobile").val();

        //判断是否输入空项
        //判断非法字符
        if (!checkReginfo(customer)) {
            return false;
        }
        if (!checkIlleagelinfo(customer)) {
            return false;
        }


        var postData = JSON.stringify(customer);
        console.log(customer);
        $.ajax({
            url: "Register.action",
            type: "post",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: postData,
            success: function (data) {
                var msgs = data.msg;
                if (msgs === "") {
                    alert(msgs);
                    return false;
                } else {
                    alert(msgs);
                    self.location = "toIndex.action";
                }
            },
            error: function () {
                alert("something was wrong");
            }
        });
    });

    /**
     * 判断是否输入空项**/
    function checkReginfo(customer) {
        if (customer.name.length < 1) {
            alert("姓名未输入");
            return false;
        } else if (customer.cardNo.length < 6) {
            alert("请输入6位以上账号");
            return false;
        } else if (customer.password.length < 6) {
            alert("密码格式不对");
            return false;
        } else if (customer.mobile.length < 11) {
            alert("手机号格式不对");
            return false;
        }
        return true;
    }

    /**
     * 注册匹配非法字符以及中文**/
    function checkIlleagelinfo(customer) {
        console.log(customer.password);
        var regAccountCN = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;

        var pattern = /^[\u4E00-\u9FA5]{1,5}$/;

        if (regAccountCN.test(customer.cardNo + customer.mobile + customer.password + customer.name)) {
            alert("请勿输入非法字符");
            return false;
        }
        if (pattern.test(customer.mobile)) {
            alert("手机号请勿输入中文");
            return false;
        }
        return true;
    }

});