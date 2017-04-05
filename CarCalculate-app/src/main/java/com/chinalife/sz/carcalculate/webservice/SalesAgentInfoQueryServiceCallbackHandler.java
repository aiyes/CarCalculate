
/**
 * SalesAgentInfoQueryServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package com.chinalife.sz.carcalculate.webservice;

    /**
     *  SalesAgentInfoQueryServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SalesAgentInfoQueryServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SalesAgentInfoQueryServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SalesAgentInfoQueryServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for salesAgentInfoQuery method
            * override this method for handling normal response from salesAgentInfoQuery operation
            */
           public void receiveResultsalesAgentInfoQuery(
                    com.chinalife.sz.carcalculate.webservice.SalesAgentInfoQueryServiceStub.SalesAgentInfoQueryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from salesAgentInfoQuery operation
           */
            public void receiveErrorsalesAgentInfoQuery(java.lang.Exception e) {
            }
                


    }
    