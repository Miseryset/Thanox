/*
 * (C) Copyright 2022 Thanox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package now.fortuitous.thanos.onboarding

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import github.tornaco.android.thanos.util.ActivityUtils
import now.fortuitous.thanos.main.NavActivity
import tornaco.apps.thanox.base.BaseActivity
import tornaco.apps.thanox.base.ui.theme.ThanosTheme

class OnBoardingActivity : BaseActivity() {

    object Starter {
        fun start(context: Context?) {
            ActivityUtils.startActivity(context, OnBoardingActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThanosTheme {
                val context = LocalContext.current
                OnBoardingScreen {
                    now.fortuitous.thanos.pref.AppPreference.setHasOnBoarding(context, true)
                    NavActivity.Starter.start(context)
                    finish()
                }
            }
        }
    }
}
