/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.logging.Level;




public class CurrentTimeUtility  {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentTimeUtility.class);

    
    public static Date getCurrentUTCDateAndTime() {

        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

//Local time zone   
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

//Time in GMT
        Date utcDate;
        try {
            utcDate = dateFormatLocal.parse(dateFormatGmt.format(new Date()));
        } catch (ParseException ex) {
            LOGGER.error(ex.getMessage());
            return null;
        }

        return utcDate;
    }
}
