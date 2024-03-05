# from selenium import webdriver
# from bs4 import BeautifulSoup
# import sys
# from PyQt4.QtCore import *
# from PyQt4.QtGui import *
# from PyQt4 import QtGui, QtCore
# import time
# from selenium.webdriver.common.by import By
# from selenium.webdriver.support.ui import WebDriverWait
# from selenium.webdriver.support import expected_conditions as EC
#time.sleep(10)
# size_btn = pag.moveTo(2726,741,duration = 0)
# pag.click(size_btn)
# pag.click(size_btn)
# size_select_btn = pag.moveTo(2707,815,duration=0)
# pag.click(size_select_btn)
# perchase_select_btn = pag.moveTo(2757,1095)
# pag.click(perchase_select_btn)

# mouse_position = pag.position()
# print(mouse_position)

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support import expected_conditions as EC
import time

userID = "another0306"
userPW = "whtjdals0306!"

options = Options()
options.add_experimental_option("detach", True)
options.add_argument('--incognito')
driver = webdriver.Chrome(service= Service(ChromeDriverManager().install()))

def log_in():
    try:
        url = "https://www.polyteru-store.com/login?checkDomain=MEMBER_DOMAIN"
        driver.get(url)
        driver.find_element(By.XPATH, "//*[@id = 'loginUid']").send_keys(userID)
        driver.find_element(By.XPATH, "//*[@id = 'loginPassword']").send_keys(userPW)
        driver.find_element(By.XPATH, "//*[@id = 'btn_login']").click()
    except Exception as e:
        print(e)
        print("got exception log in")

def select_item():
    try:
        time.sleep(0.5)
        driver.find_element(By.XPATH, "//*[@id = 'headerMenuHamburgerBar']").click()
        print("돌아감")
        time.sleep(0.5)
        driver.find_element(By.XPATH, "//*[@alt = '가게']").click()
        # print("돌아감")
        time.sleep(0.5)
        page_height = driver.execute_script("return document.body.scrollHeight")
        driver.execute_script(f"window.scrollTo(0, {page_height});")
        time.sleep(0.5)
        driver.find_element(By.XPATH, "//*[@page = '2']").click()
        # page_2_button = WebDriverWait(driver, 10).until(
        # EC.element_to_be_clickable((By.XPATH, "//a[text()='2']")))
        # page_2_button.click()
        print("돌아감")
        page_height = driver.execute_script("return document.body.scrollHeight")
        middle_of_page = page_height / 3
        driver.execute_script(f"window.scrollTo(0, {middle_of_page});")
        store_element = driver.find_element_by_xpath("//*[contains(text(), '(12.14 PM6:00) double breasted coat 2.0 - black')]")
        store_element.click()
    except Exception as e:
        print(e)
        print("get exception select_item ")
print("돌아갑니다")
url = "https://www.polyteru-store.com/"
driver.get(url)
log_in()
select_item()
time.sleep(1000)
