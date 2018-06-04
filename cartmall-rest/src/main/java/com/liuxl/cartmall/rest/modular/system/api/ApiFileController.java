package com.liuxl.cartmall.rest.modular.system.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.liuxl.cartmall.core.base.tips.R;
import com.liuxl.cartmall.core.oss.OSSClientUtil;

import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping("/system")
public class ApiFileController {

	@Autowired
	OSSClientUtil oSSClientUtil;
	
	 /**
     * 普通上传
     * @param files
     * @param type
     * @param isCover
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public R uploadFile(
            @RequestParam(value = "file", required = false) MultipartFile[] files,
            @RequestParam(required = false, defaultValue = "0") Integer type,
            @RequestParam(required = false, defaultValue = "0") Integer isCover){
    	
        List<String> urlList = new ArrayList<>();
        if (files == null)
            return R.error(404, "no files");
        if (isCover == 1 && files.length > 0) {
            files = new MultipartFile[] { files[files.length - 1] };
        }
        for (MultipartFile f : files) {
            String name = oSSClientUtil.uploadImg2Oss(f);
            String url = oSSClientUtil.getImgUrl(name);
            int index = url.indexOf("?");
            if(index > 0)
                url =url.substring(0,index);
            urlList.add(url);
            urlList.add(f.getOriginalFilename());
            InputStream is = null, is1 = null;
            ByteArrayOutputStream bos = null;
            if (type != null && type == 1) {
                try {
                    is = f.getInputStream();
                    bos = new ByteArrayOutputStream();
                    // 压缩图片
                    if(name.endsWith(".jpg")||name.endsWith(".JPG")||name.endsWith(".png")||name.endsWith(".PNG")||name.endsWith(".jpeg")||name.endsWith(".JPEG")){
                        Thumbnails.of(is).scale(0.4).toOutputStream(bos);
                    }
                    byte[] b = bos.toByteArray();
                    is1 = new ByteArrayInputStream(b);
                    String newName = name.substring(0, name.lastIndexOf(".")) + "_mini"+ name.substring(name.lastIndexOf("."));
                    oSSClientUtil.uploadFile2OSS(is1, newName);
                    url = oSSClientUtil.getImgUrl(newName);
                    int index2 = url.indexOf("?");
                    if(index2 > 0)
                        url =url.substring(0,index2);
                    urlList.add(url);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                        is1.close();
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //向系统

        }
        return R.ok().put("urlList", urlList);
    }

}
