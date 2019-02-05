<!DOCTYPE html>
<html lang="zh-cn" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>账本</title>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap.css"
          th:href="@{/bootstrap/css/bootstrap.css}"/>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap-grid.css"
          th:href="@{/bootstrap/css/bootstrap-grid.css}"/>
    <link rel="stylesheet" type="text/css" href="../static/bootstrap/css/bootstrap-reboot.css"
          th:href="@{/bootstrap/css/bootstrap-reboot.css}"/>
</head>
<body>
<div class="container" id="App">
    <div class="card">
        <form id="dataForm" @submit.prevent="submitForm">
            <div class="card-header">
                <h3 class="text-center">记账</h3>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="type">类型：</label>
                    <div class="form-control" id="type">
                        <span class="mx-3" v-for="type in types" v-cloak>
                        {{type.title}}
                        <input name="type" type="radio" :value="type.value" required v-model="formObj.type"/>
                    </span>
                    </div>
                    <label for="title">标题：</label>
                    <input class="form-control" type="text" name="title" id="title" v-model="formObj.title" required/>
                    <label for="date">日期：</label>
                    <input class="form-control" type="date" id="date" name="date" v-model="formObj.date"
                           required/>
                    <label for="price">金额：</label>
                    <input class="form-control" type="number" id="price" name="price" v-model="formObj.price" required/>
                    <label for="info">说明：</label>
                    <textarea class="form-control" name="info" id="info" cols="50" rows="7"
                              v-model="formObj.info"></textarea>
                </div>
            </div>
            <div class="card-footer">
                <div class="form-inline">
                    <div class="mx-auto">
                        <button class="btn btn-primary mx-3" type="reset">重置</button>
                        <button class="btn btn-success mx-3" type="submit">提交</button>
                        <button class="btn btn-secondary mx-3" type="button" @click="goBack">返回</button>

                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="../static/js/jquery.js" th:src="@{/js/jquery.js}"></script>
<script src="../static/js/vue.js" th:src="@{/js/vue.js}"></script>
<script src="../static/js/vue-resource.js" th:src="@{/js/vue-resource.js}"></script>
<script src="../static/bootstrap/js/bootstrap.js" th:src="@{/bootstrap/js/bootstrap.js}"></script>
<script src="../static/bootstrap/js/bootstrap.bundle.js" th:src="@{/bootstrap/js/bootstrap.bundle.js}"></script>
<script src="../static/js/common.js" th:src="@{/js/common.js}"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    var vm = new Vue({
        el: "#App",
        data: {
            types: [],
            formObj: {
                type: null,
                title: null,
                date: null,
                price: null,
                info: null,
            }

        },
        methods: {
            goBack() {
                window.location.href = '/index';
            },
            submitForm() {
                var self = this;
                $.ajax({
                    type: 'post',
                    url: '/addOne',
                    data: self.formObj,
                    dataType: 'json',
                    async: true,
                    contentType: 'application/x-www-form-urlencoded',
                    success: function (data) {
                        if (data['result'] == 'success') {
                            alert("添加成功!");
                            window.location.href = '/';
                        } else {
                            alert("添加失败!");
                        }
                    },
                    error: function () {

                        alert("添加失败!");
                    }
                })
                // axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
                // axios.post('/addOne', self.formObj).then(resp => {
                //     if (resp.data == 'success') {
                //         alert("添加成功!");
                //         window.location.href = '/';
                //     } else {
                //         alert("添加失败!");
                //     }
                // }), function () {
                //     alert("添加失败!");
                // }
            }
        },
        mounted: function () {
            var self = this;

            axios.post(`/initializePage`).then((resp) => {
                var data = eval(resp.data);
                self.types = data['types'];
            })
        }
    });
</script>
</html>