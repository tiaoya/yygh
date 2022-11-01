import request from '@/utils/request'

const API = "/admin/cmn";

export default{

    getDictList(pid) {
        return request({
          url: `${API}/childList/${pid}`,
          method: 'get',
        })
    }
    
}

