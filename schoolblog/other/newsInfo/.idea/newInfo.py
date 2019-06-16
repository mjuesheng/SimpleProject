# -*- coding: utf-8 -*-
import requests
from lxml import etree
import json
import urllib
headers = {
	"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36"
}

# 根据url获取刚网页中的新闻详情页的网址列表
def getNewsDetailUrlList(url):
	"""
	:param url: 每页的URL
	:return newDetailList:每页包含的新闻详情URL
	"""
	response = requests.get(url, headers=headers)
	html = response.content.decode('gbk')
	selector = etree.HTML(html)
	newsDetailList = selector.xpath('//ul[@id="news-flow-content"]//li//div[@class="titleBar clearfix"]//h3//a/@href')
	return newsDetailList

# 获取新闻标题
def getNewsTitle(detailUrl):
	"""
	:param detailUrl:新闻详情url
	:return newsTitle:新闻标题
	"""
	response = requests.get(detailUrl, headers=headers)
	try:
		html = response.content.decode('gbk').encode("utf-8")
		selector = etree.HTML(html)
		newsTitle = selector.xpath('//div[@class="post_content_main"]//h1/text()')
		return newsTitle
	except:
		pass
	return " "

# 获取图片地址
def getImgUrl(detailUrl):

	response = requests.get(detailUrl, headers=headers)
	try:
		html = response.content.decode('gbk').encode("utf-8")
		selector = etree.HTML(html)
		imgUrl = selector.xpath('//div[@class="post_text"]//p[@class="f_center"]//img/@src')
		return imgUrl
	except:
		pass
	return " "

# 获取新闻详情内容
def getNewsContent(detailUrl):
	"""
	:param detailUrl: 新闻详情url
	:return newsContent: 新闻内容详情
	"""
	response = requests.get(detailUrl, headers=headers)
	html = response.content.decode('gbk')
	selector = etree.HTML(html)
	newsContent = selector.xpath('//div[@class="post_text"]//p/text()')
	return newsContent

# 将新闻标题和内容写入文件
	TODO

# 获取翻页网址列表
def getUrlList(baseUrl, num):
	"""
	:param baseUrl:基础网址
	:param num: 翻到第几页
	:return urlList: 翻页网址列表
	"""
	urlList = []
	urlList.append(baseUrl)
	for i in range(2, num+1):
		urlList.append(baseUrl + "_" + str(i).zfill(2))
	return urlList

#运行
if __name__ == '__main__':
	baseUrl = "http://tech.163.com/special/gd2016"
	#num = int(input('输入你要爬取的页数: '))
	num = 20;
	urlList = getUrlList(baseUrl, num)
	detailUrl = []

	for url in urlList:
		for i in getNewsDetailUrlList(url):
			detailUrl.append(i)
		j=0;
	while j < num:
		print str(getNewsTitle(detailUrl[j])).decode('string - escape')
		try:
			print str(getImgUrl(detailUrl[j])[0]).decode('string - escape')
		except:
			pass
		if getNewsTitle(detailUrl[j])!=" ":
			print detailUrl[j]
		j = j + 1

print "正在写入文件。。。"
# # 将爬取的文本存入文本文件
with open('E://pythonPj/newsInfo/saveText/newsInfo.txt', 'wb') as f:
    j=0
    while j < num:
        if getNewsTitle(detailUrl[j]) != " ":
            try:
                f.write(''.join("标题 " + str(getNewsTitle(detailUrl[j])).decode('string - escape')[3:]))
                f.write('\n')
                f.write(''.join("图片地址 " + str(getImgUrl(detailUrl[j])[0]).decode('string - escape')))
                f.write('\n')
                f.write(''.join("新闻地址 " + detailUrl[j]))
                f.write('\n')
            except:
                pass
        j = j + 1
	print('文件写入成功')