package springbootactuatorlab.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/auth")
    public class SecurityController {

        @GetMapping("/status")
        public ResponseEntity<String> getStatus() {
            ResponseEntity<String> responseEntity = new ResponseEntity<>("Resource is fetched", HttpStatus.OK);


            return responseEntity;
        }


    }

