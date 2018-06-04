package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {
    //
    static HashMap<String, String>mysearch=new HashMap<>();
    //
    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }
    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value ="/results/", method = RequestMethod.GET)
    public String displaySearchform(Model model){
        model.addAttribute("title", "Search");
        return "search";
    }
    @RequestMapping(value="/results/", method=RequestMethod.POST)

    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        //model.addAttribute("columns", ListController.columnChoices);
        //
/*        ArrayList<HashMap<String, String>> myjobs = new ArrayList<>();
        //HashMap<String, String>aljobs=new HashMap<>();
        //aljobs=JobData.findByValue(searchTerm);
        //HashMap<String, String> myjobs= new HashMap<>();
        String numberjob = "";
        ///private static void search(ArrayList<HashMap<String, String>> someJobs){
        if (searchTerm.contains("all")) {
            //System.out.println("No result found!");
            myjobs= JobData.findByValue(searchTerm);
            model.addAttribute("allJobs", myjobs);*/

          ////
            int jobcounter=0;
            if (searchType.equals("all")) {

                ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);

                for(HashMap<String, String> job : jobs) {
                    jobcounter=job.size();

                    model.addAttribute("job", job);
                    for (Map.Entry<String, String> jj : job.entrySet()) {

                        model.addAttribute("jobcounter", jobcounter);
                        model.addAttribute("jobs", jobs);
                        String keydescription = jj.getKey();
                        String valuedescription = jj.getValue();
                        model.addAttribute("keydescription", keydescription);
                        model.addAttribute("valuedescription", valuedescription);
                    }
                }
                return "search";
            } else {

                ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);

                model.addAttribute("jobs", jobs);

                for(HashMap<String, String> job : jobs) {
                    jobcounter=job.size();

                    model.addAttribute("job", job);
                    model.addAttribute("job", job);
                    for (Map.Entry<String, String> jj : job.entrySet()) {

                        //System.out.println(jj.getKey() + ": " + jj.getValue());
                        String keydescription=jj.getKey();
                        String valuedescription=jj.getValue();
                        model.addAttribute("keydescription", keydescription);
                        model.addAttribute("valuedescription",valuedescription);

                    }
                }

                return "search";
            }

        }}


          ////

        /*} else {

            for (HashMap<String, String> job : JobData.findByValue(searchTerm)) {

                //System.out.println("******************");

                for (Map.Entry<String, String> jj : job.entrySet()) {

                    //System.out.println(jj.getKey() + ": " + jj.getValue());

                    myjobs.(jj.getKey(), jj.getValue()); // Mapping the joblist
                    //model.addAttribute("myjobs", myjobs);
                }
                //System.out.println(" "); // replaced by <tr></tr> in search index to mean empty row between jobs
                numberjob = JobData.findByValue(searchTerm).size() + " jobs found";

            }

        }
        return "search";
    }}*/

    /**@RequestMapping(value ="results", method = RequestMethod.POST)
    //
    public  String search(@RequestParam String searchType,
                          @RequestParam String searchTerm){
                          //@RequestParam
        ArrayList<HashMap<String, String>>allJobs;
        ArrayList<HashMap<String, String>> searchItem = new ArrayList<>();
        allJobs= JobData.findAll();
        mysearch.put(searchType, searchTerm);
        //model.addAttribute("searchType", ListController.columnChoices.get(searchType));
        //model.addAttribute("searchTerm", searchTerm);
        //model.addAttribute("allJobs", JobData.findAll());
        for (HashMap<String, String> row : allJobs) {
            for (Map.Entry<String, String> mylisting : row.entrySet()){
                int countjob=0;
                if (mylisting.getValue().toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchItem.add(row);
                    countjob+=1;
                }
            }
        }

        return "search";
    }**/


/*

     @RequestMapping(value="results", method=RequestMethod.POST)

     public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

     model.addAttribute("columns", ListController.columnChoices);



     // TODO - Implement 'all' search



     if (searchType.equals("all")) {

     ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);

     model.addAttribute("jobs", jobs);

     return "search";



     } else {

     ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);

     model.addAttribute("jobs", jobs);

     return "search";

     }

     }
*/




    //**@RequestMapping(value="results", method=RequestMethod.POST)
    // Print a list of jobs
   // private static void search(ArrayList<HashMap<String, String>> someJobs) {

// 2 lines of code here
        /*/
        if(someJobs.isEmpty()){
            System.out.println("No result found!");
        }else{


            for (HashMap<String, String> job : someJobs) {
                HashMap<String, String> jobd=new HashMap<>();

                System.out.println("******************");
                for (Map.Entry<String, String> jj : job.entrySet()) {
                    //System.out.println(jj.getKey() + ": " + jj.getValue());
                    job.put(jj.getKey(), jj.getValue());

                }

            }

        }


    } **/




// 2 lines of code here

