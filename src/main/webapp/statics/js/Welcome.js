$(document).ready(function () {
    /**用户注册
     */
    $("button.login").click(
        function () {
            var username = $("input.username").val();
            var password = $("input.password").val();
            if (username.length == 0 || password.length == 0) {
                alert("账号或密码未输入");
                return false;
            }
        });

    /**显示注册界面
     */
    $("button.register").click(function () {
        $("#register").show();
        $("#div01").hide();
    });

    /**会员信息注册，注册前检查输入是否有误
     */
    $("button.postCus").click(function () {
        var dad =  $("#register");
        var customer = {};
        customer.cardNo = dad.children(".username").val();
        customer.name = dad.children(".name").val();
        customer.password = dad.children(".password").val();
        customer.mobile = dad.children(".mobile").val();
        /**匹配非法字符
         * */
        var patrn=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
        /**匹配中文
         * */
        var  regAccountCN = /[\u4e00-\u9fa5]+/g;
       if (patrn.test(customer.cardNo+customer.mobile+customer.password+customer.name)){
            alert("请勿输入非法字符");
           return false;
        }
        /*if (regAccountCN.test(customer.cardNo+customer.mobile+customer.password)){
            alert("请勿使用中文");
            return false;
        }*/
        var postData = JSON.stringify(customer);
        console.log(customer);
        $.ajax({
            url : "Register.action",
            type : "post",
            dataType:"json",
            contentType: "application/json;charset=utf-8",
            data : postData,
            success:function(data){
                if(data.msg == ""){
                    alert("注册失败");
                    return false;
                }else {
                    alert("卡号："+data.msg+"注册成功");
                    self.location = "toIndex.action";
                }
            },
            error:function () {
                alert("something was wrong");
            }
        });
        });
});