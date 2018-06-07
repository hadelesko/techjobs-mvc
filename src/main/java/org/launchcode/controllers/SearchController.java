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
    @RequestMapping(value ="search", method = RequestMethod.GET)
    public String displaySearchform(Model model){
        model.addAttribute("title", "search");
        return "search";
    }
    @RequestMapping(value="results", method=RequestMethod.POST)

    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        model.addAttribute("column", ListController.columnChoices);

            int jobcounter=0;
            if (searchType.equals("all")) {

                ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
                //jobcounter=jobs.size();

                model.addAttribute("jobs", jobs);
                String resultcounter=jobs.size()+" Result(s)";
                model.addAttribute("jobcounter", resultcounter);

                for(HashMap<String, String> job : jobs) {

                    model.addAttribute("job", job);
                    for (Map.Entry<String, String> jj : job.entrySet()) {

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
                String resultcounter=jobs.size()+" Result(s)";
                model.addAttribute("jobcounter", resultcounter);
                //model.addAttribute("resultcounter", resultcounter)

                for(HashMap<String, String> job : jobs) {

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

        }
}









