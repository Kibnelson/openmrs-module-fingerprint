

package org.openmrs.module.peer.model;

import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: nelson
 * Date: 12/20/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class ModelController {


    public static ModelController modelController;

    private JSONObject jsonObjectVal;
    private static Integer maximumResults;


    public ModelController(){


    }

    public  static ModelController getModelController(){

        ModelController thiClass=null;

        if(modelController ==null) {


            modelController =new ModelController();
            thiClass= modelController;

        }
        else
            thiClass= modelController;

        return  thiClass;

    }

    public void sendResponse( HttpServletResponse response, JSONObject jsonObject){


        try {


            response.getWriter().print(jsonObject);
            response.flushBuffer();
        } catch (Exception e) {

            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
