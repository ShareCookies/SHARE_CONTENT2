const UrlUtil = {
    delUrlParam: function (url, ref) {
        // 如果不包括此参数
        if (url.indexOf(ref) == -1)
            return url;
        const arrUrl = url.split('?');
        const base = arrUrl[0];
        const arrParam = arrUrl[1].split('&');
        let index = -1;
        let i = 0;
        for (i = 0; i < arrParam.length; i++) {
            const paired = arrParam[i].split('=');
            if (paired[0] == ref) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return url;
        } else {
            arrParam.splice(index, 1);
            return base + '?' + arrParam.join('&');
        }
    },
    getUrlParam: function (url, ref) {
        // 如果不包括此参数
        if (url.indexOf(ref) == -1)
            return url;
        const arrUrl = url.split('?');
        const arrParam = arrUrl[1].split('&');
        let i = 0;
        let result = '';
        for (i = 0; i < arrParam.length; i++) {
            const paired = arrParam[i].split('=');
            if (paired[0] == ref) {
                result = paired[1];
            }
        }
        return result;
    }
};
export { UrlUtil };
