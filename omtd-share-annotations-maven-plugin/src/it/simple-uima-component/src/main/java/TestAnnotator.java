/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.ExternalResource;
import org.apache.uima.fit.descriptor.LanguageCapability;
import org.apache.uima.fit.descriptor.MimeTypeCapability;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.Resource;

import eu.openminted.registry.domain.ComponentTypeEnum;
import eu.openminted.registry.domain.ProcessingResourceTypeEnum;
import eu.openminted.share.annotations.api.Component;
import eu.openminted.share.annotations.api.DataFormat;
import eu.openminted.share.annotations.api.Language;
import eu.openminted.share.annotations.api.ResourceInput;
import eu.openminted.share.annotations.api.ResourceOutput;

@Component(ComponentTypeEnum.SEGMENTER)
@ResourceInput(
        type = ProcessingResourceTypeEnum.CORPUS,
        encoding = "UTF-8",
        keyword = "some keyword",
        annotationLevel = "lemmatization",
        language = @Language(languageId="en", languageTag="en", scriptId="Latn", regiontId="154", variantId="fonipa"),
        dataFormat = @DataFormat(dataFormat = "conll2000", mimeType = "text/tab-separated-values", fileExtension = ".conll"))
@ResourceOutput(
        type = ProcessingResourceTypeEnum.CORPUS,
        encoding = "UTF-8",
        keyword = "some keyword",
        annotationLevel = "lemmatization",
        language = @Language(languageId="en", languageTag="en", scriptId="Latn", regiontId="154", variantId="fonipa"),
        dataFormat = @DataFormat(dataFormat = "conll2000", mimeType = "text/tab-separated-values", fileExtension = ".conll"))
@MimeTypeCapability("text/tab-separated-values")
@LanguageCapability("en")
public class TestAnnotator extends AbstractAnnotator {

  /**
   * Parameter value 1.
   */
  public static final String PARAM_VALUE_1 = "value1";
  @ConfigurationParameter(name = PARAM_VALUE_1, mandatory=true)
  private String value1;

  /**
   * Documentation for resource
   */
  public static final String RES_KEY = "res";
  @ExternalResource(key = RES_KEY)
  private Resource res;

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // Nothing to do
  }
}
