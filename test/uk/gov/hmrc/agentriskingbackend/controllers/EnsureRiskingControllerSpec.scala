/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.agentriskingbackend.controllers

import play.api.http.Status
import play.api.libs.json.Json
import play.api.mvc.Result
import play.api.test.Helpers.*
import play.api.test.FakeRequest
import play.api.test.Helpers
import uk.gov.hmrc.agentriskingbackend.testsupport.ControllerSpec

import scala.concurrent.Future

class EnsureRiskingControllerSpec
extends ControllerSpec:

  private val fakeRequest = FakeRequest("POST", "/")
  private val controller = new EnsureRiskingController(Helpers.stubControllerComponents())

  "return NoContent if body has no json" in:
    val result = controller.run()(fakeRequest)
    status(result) shouldBe Status.NO_CONTENT

  "return Ok(json) if body has json" in:
    val fakeRequestWithBody = fakeRequest.withJsonBody(Json.parse("{}"))
    val result: Future[Result] = controller.run()(fakeRequestWithBody)
    status(result) shouldBe Status.OK
