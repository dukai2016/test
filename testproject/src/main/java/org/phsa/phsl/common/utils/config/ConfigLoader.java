/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.phsl.common.utils.config;
import java.util.Properties;
/**
 *
 * @author kai.du
 */
public interface ConfigLoader {
    Properties getConfig(String file);
}
