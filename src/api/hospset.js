import request from '@/utils/request'



const API="/admin/hosp/hospitalSet";
//es6导出语法
export default {

    // 带查询条件条件的分页
    getHospsetPage(pageNum,size,searchObj) {
        return request({
          url: `${API}/page/${pageNum}/${size}`,
          method: 'post',
          //如果携带的是普通参数：params,如果携带的是json数据：data
          data:searchObj
      })
    },

      // 根据id 删除某个医院设置信息
    removeDataById(id){
        return request({
          url: `${API}/deleteById/${id}`,
          method: 'delete'
      })
    },

    // 医院添加
    addHospital(obj){
      return request({
        url:`${API}/save`,
        method:'post',
        data : obj
      })
    },
    
    // 修改回显 
    detail(id){
      return request({
        url:`${API}/detail/${id}`,
        method:'get'
      })
    },

    // 医院设置修改数据 
    update(obj){
      return request({
        url:`${API}/update`,
        method:'put',
        data:obj
      })
    },

    
    // 批量删除设置 
    batchDelete(ids){
      return request({
        url:`${API}/delete`,
        method:'delete',
        data:ids
      })
    },

}
