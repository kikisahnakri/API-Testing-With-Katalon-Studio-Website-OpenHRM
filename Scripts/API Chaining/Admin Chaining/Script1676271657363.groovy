import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

response = WS.sendRequest(findTestObject('Admin/01 - Get User'))

WS.verifyResponseStatusCode(response, 200)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

String apiPostLoanResponse = response.getResponseText()

def value = result.data[7].employeeId

println('inii idddddddddd' + value)

def id = value

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'data[0].userName', 'Admin')

WS.verifyElementPropertyValue(response, 'data[0].userRole', 'Admin')

WS.verifyElementPropertyValue(response, 'data[0].status', 'Enabled')

WS.verifyElementPropertyValue(response, 'data[0].employeeName', 'Boss Besar (Past Employee)')

WS.verifyElementPropertyValue(response, 'data[0].employeeId', 1)

response1 = WS.sendRequestAndVerify(findTestObject('Admin/02 - Post User Login', [('employeeId') : id]))

def slurper1 = new groovy.json.JsonSlurper()

def result1 = slurper1.parseText(response1.getResponseBodyContent())

String apiPostLoanResponse1 = response1.getResponseText()

WS.verifyResponseStatusCode(response1, 200)

WS.verifyElementPropertyValue(response1, 'user.employeeId', 4)

response2 = WS.sendRequestAndVerify(findTestObject('Admin/03 - Get Organization Information'))

WS.verifyResponseStatusCode(response2, 200)

WS.verifyElementPropertyValue(response2, 'data.id', '1')

WS.verifyElementPropertyValue(response2, 'data.name', 'Sekolah Digital Cilsy')

