package com.test.upload;
import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;


import org.apache.commons.io.FileUtils;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class FileUpload extends MVCPortlet {


    private final static int ONE_GB = 1073741824;
    
    private final static String baseDir = "E:/gms";

    private final static String deptListName = "option";

    private final static String fileInputName = "fileupload";

    public void upload(ActionRequest request, ActionResponse response)
          throws Exception {

   UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

     long sizeInBytes = uploadRequest.getSize(fileInputName);
       if (uploadRequest.getSize(fileInputName) == 0) {

            throw new Exception("Received file is 0 bytes!");

        }
       File uploadedFile = uploadRequest.getFile(fileInputName);


        String sourceFileName = uploadRequest.getFileName(fileInputName);
     

        File folder = new File(baseDir+"/"+deptListName);
        if (!folder.exists()) {

            if (folder.mkdir()) {

                System.out.println("Directory is created!");

            } else {

                System.out.println("Failed to create directory!");

            }

        }
        if (folder.getUsableSpace() < ONE_GB) {

            throw new Exception("Out of disk space!");

        }

        File filePath = new File(folder.getAbsolutePath() + File.separator + sourceFileName);
        FileUtils.copyFile(uploadedFile, filePath);

    }

    public void option(ActionRequest request, ActionResponse response)

             throws IOException, PortletException {

    	String option=request.getParameter("option");

    }

} 