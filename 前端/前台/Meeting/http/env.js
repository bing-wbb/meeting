//commonJs预览 --- node.js采用的就是该规范	
	//什么是common.js规范:每个文件就是一个模块，有自己的作用域。在一个文件里面定义的变量、
	//函数、类，都是私有的，对其他文件不可见。
	
	//这里使用的接口呢都是自己模拟的，亲么可以根据自己的需求进行添加
    module.exports={
        //开发环境的url
        dev:{
            baseUrl:"http://localhost:8090"
        },
        //测试环境url
        test:{
            baseUrl:"http://www.test.com"
        },
        //线上环境url
        prod:{
            baseUrl:'http://localhost:8090'
        }
    }
    