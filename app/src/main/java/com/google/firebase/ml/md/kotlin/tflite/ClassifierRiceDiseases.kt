/* Copyright 2019 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/
package com.google.firebase.ml.md.kotlin.tflite

import android.app.Activity
import org.tensorflow.lite.support.common.TensorOperator
import org.tensorflow.lite.support.common.ops.NormalizeOp

/** This TensorFlow Lite classifier works with the quantized EfficientNet model.  */
class ClassifierRiceDiseases(
        activity: Activity?,
        device: Device?,
        numThreads: Int
) : Classifier(activity, device, numThreads) {

    // you can download this file from
    // see build.gradle for where to obtain this file. It should be auto
    // downloaded into assets.
    override val modelPath: String
        get() =// you can download this file from
        // see build.gradle for where to obtain this file. It should be auto
                // downloaded into assets.
            "model_rice_diseases.tflite"

    override val labelPath: String
        get() = "labels_rice_diseases.txt"

    override val preprocessNormalizeOp: TensorOperator
        get() = NormalizeOp(IMAGE_MEAN, IMAGE_STD)

    override val postprocessNormalizeOp: TensorOperator
        get() = NormalizeOp(PROBABILITY_MEAN, PROBABILITY_STD)

    companion object {
        private const val IMAGE_MEAN = 0.0f
        private const val IMAGE_STD = 255.0f

        private const val PROBABILITY_MEAN = 0.0f
        private const val PROBABILITY_STD = 1.0f
    }
}