//引入封装的reuest请求
const { request } = require('./request.js')
//基于业务封装的接口
module.exports={

	/* 轮播图 */
	// banners:()=>{
	// 	return request(','GET',{},true);
	// },
	/* 封装用户列表的方法 */
	getUserList:()=>{
		return request('要请求的路径','请求方式|GET|POST',{要携带的参数},是否添加子域名 |true|false);
	},
	/* 添加用户 */
	addGoods: (url,data)=>{
		return request(url, 'POST',data,false);
    },
    	/* 得到所有会议室的列表 */
	getRoom: (url,data)=>{
		return request(url, 'POST',data,false);
    },
        	/* 得到所有公告的列表 */
	getNotice: (url,data)=>{
		return request(url, 'POST',data,false);
    },
    getDetail: (url,data)=>{
		return request(url, 'POST',data,false);
    },
    add:(url,data)=>{
		return request(url, 'POST',data,false);
    },
	/* 获取商品的分类 */
	getGoodsCate:()=>{
		return request('要请求的路径','GET',{},true);
	}
}
