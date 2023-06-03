package Utils;

import APIStepDefinitions.APIWorkflowSteps;
import net.bytebuddy.asm.Advice;
import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload="{\n" +
                "  \"emp_firstname\": \"Ali\",\n" +
                "  \"emp_lastname\": \"kaka\",\n" +
                "  \"emp_middle_name\": \"sa\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-04-21\",\n" +
                "  \"emp_status\": \"Parttime\",\n" +
                "  \"emp_job_title\": \"Manager\"\n" +
                "}";

        return createEmployeePayload;
    }
    public static String createEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname", "Ali");
        obj.put("emp_lastname", "kaka");
        obj.put("emp_middle_name", "sa");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2000-04-21");
        obj.put("emp_status", "Parttime");
        obj.put("emp_job_title", "Manager");

        return obj.toString();
    }

    public static String createEmployeePayloadDynamic(String emp_firstname,
                                                      String emp_lastname,
                                                      String emp_middle_name,
                                                      String emp_gender,
                                                      String emp_birthday,
                                                      String emp_status,
                                                      String emp_job_title){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id", "58038A");
        obj.put("emp_firstname", "Simsim");
        obj.put("emp_lastname", "Al");
        obj.put("emp_middle_name", "s");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2001-04-21");
        obj.put("emp_status", "FullTime");
        obj.put("emp_job_title", "CEO");

        return obj.toString();
    }


}
