package com.example.demo.commom.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

@Slf4j
public class StringUtility {

	public static List removeDuplicate(List list) {
		if (list == null || list.size() == 0) return list;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).equals(list.get(i))) {
					list.remove(j);
				}
			}
		}
		return list;
	}


	public static byte[] base64Decode(byte[] arrSrc) {
		return new org.apache.commons.codec.binary.Base64().decode(arrSrc);
	}

	public static byte[] base64Decode(String strEncode) throws UnsupportedEncodingException {
		if (StringUtility.isNullOrEmpty(strEncode)) {
			return new byte[0];
		}
		return base64Decode(strEncode.getBytes("utf-8"));
	}

	/**
	 * Base64加密
	 *
	 * @param strSrc
	 * @return
	 */
	public static String Base64Encode(String strSrc) {
		byte[] b = StringUtility.string2Byte(strSrc);
		return Base64Encode(b);
	}

	public static String Base64Encode(byte[] b) {
		try {
			org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
			b = base64.encode(b);
			return StringUtility.byteToStringUTF8(b);
		} catch (Exception ex) {
			log.error(String.format("%s %s", "Base64Encode", Arrays.toString(b)), ex);
		}
		return StringUtility.Empty;
	}

	/**
	 * Base64解密
	 *
	 * @param encodeStr
	 * @return
	 */
	public static String Base64EncodeDecode(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
		b = base64.decode(b);
		return new String(b);
	}

	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();

		String line = null;

		try {

			while ((line = reader.readLine()) != null) {

				sb.append(line + "/n");

			}

		} catch (IOException e) {

			log.error(e.getMessage(), e);

		} finally {

			try {

				is.close();

			} catch (IOException e) {

				log.error(e.getMessage(), e);

			}

		}

		return sb.toString();

	}



	public static String toLowerCase(String src) {
		if (isNullOrEmpty(src))
			return Empty;
		return src.toLowerCase();
	}

	/**
	 * 获取小写形式的guid
	 *
	 * @return
	 */
	public static String getGuidLowercase() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toLowerCase();
	}

	/**
	 * 获取当前时间
	 *
	 * @return
	 */
	public static Date getDateTimeNow() {
		return new Date();
	}

	/**
	 * 获取当前时间 yyyy-MM-dd HH:mm:ss SSS
	 *
	 * @return
	 */
	public static String getDateTimeNow_yyyyMMddHHmmssSSS() {
		return getDateTime_yyyyMMddHHmmssSSS(new Date());
	}

	/**
	 * 将时间转换为 yyyy-MM-dd HH:mm:ss SSS
	 *
	 * @param dt
	 * @return
	 */
	public static String getDateTime_yyyyMMddHHmmssSSS(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat(DtFormatString);// 设置日期格式
		return df.format(dt);
	}

	/**
	 * 转换为 HH:mm 格式
	 *
	 * @param dt
	 * @return
	 * @author PanYun 2016年1月5日 下午3:08:03
	 */
	public static String getDateTime_HH_mm(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat(DtFormatString_HH_mm);// 设置日期格式
		return df.format(dt);
	}

	public static String dt2Str(Date dt, String fmt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat(fmt);// 设置日期格式
		return df.format(dt);
	}

	/**
	 * 将时间转换为 yyyy-MM-dd HH:mm:ss
	 *
	 * @param dt
	 * @return
	 */
	public static String getDateTime_yyyyMMddHHmmss(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat(DtFormatString_NoMillSecond);// 设置日期格式
		return df.format(dt);
	}

	/**
	 * 将时间转换为 MM-dd HH:mm:ss
	 *
	 * @param dt
	 * @return
	 */
	public static String getDateTime_MMddHHmmss(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat(TimeFormatString_NoMillSecond);// 设置日期格式
		return df.format(dt);
	}

	public static String getGMTStr(long lMillSencod) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(lMillSencod);// new Date().getTime() + lCacheSeconds *
		// 1000);
	}

	public static String dt2Str_yyyyMM(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");// 设置日期格式
		return df.format(dt);
	}

	/**
	 * 将时间转换为 yyyy-MM-dd
	 *
	 * @param dt
	 * @return
	 */
	public static String getDateTime_yyyyMMdd(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat(DtFormatString_Date);// 设置日期格式
		return df.format(dt);
	}

	/**
	 * 转换为无减号日期格式：yyyyMMddHHmmssSSS
	 *
	 * @param dt
	 * @return
	 */
	public static String get_yyyyMMddHHmmssSSS(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
		return df.format(dt);
	}

	/**
	 * 转换为无减号日期格式：yyyyMMddHHmmss
	 *
	 * @param dt
	 * @return
	 */
	public static String get_yyyyMMddHHmmss(Date dt) {
		if (dt == null)
			return Empty;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		return df.format(dt);
	}

	private static Date dtMinValue = new Date();
	public static final String DtFormatString = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DtFormatString_NoMillSecond = "yyyy-MM-dd HH:mm:ss";
	public static final String TimeFormatString_NoMillSecond = "MM-dd HH:mm:ss";
	public static final String DtFormatString_Date = "yyyy-MM-dd";
	public static final String DtFormatString_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	/**
	 * HH:mm
	 *
	 * @author PanYun 2016年1月5日 下午3:07:46
	 */
	public static final String DtFormatString_HH_mm = "HH:mm";

	/**
	 * 获取日期最小值
	 *
	 * @return
	 */
	public static Date getDateMinValue() {
		return dtMinValue;
	}

	/**
	 * 字符串(yyyy-MM-dd HH:mm:ss SSS)转Date
	 *
	 * @param strDt
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Date(String strDt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DtFormatString);
		return sdf.parse(strDt);
	}

	/**
	 * 字符串(yyyyMMddHHmmss)转Date
	 *
	 * @param strDt
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Date_yyyyMMddHHmmss(String strDt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DtFormatString_yyyyMMddHHmmss);
		return sdf.parse(strDt);
	}

	public static Date string2Date(String strDt, String strFmt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(strFmt);
		return sdf.parse(strDt);
	}

	public static Date string2Date_yyyyMMddHHmmss(String strDt, Date dtDefault) {
		try {
			return string2Date_yyyyMMddHHmmss(strDt);
		} catch (Exception ex) {
			return dtDefault;
		}
	}

	/**
	 * 转化为字符串，空对象返回 String.Empy
	 *
	 * @param obj
	 * @return
	 */
	public static String convertToString(Object obj) {
		if (obj == null)
			return StringUtility.Empty;
		return obj.toString();
	}

	public static Integer convertToInteger(Object obj) {
		try {
			return Integer.parseInt(convertToString(obj));
		} catch (Exception ex) {
			return Integer.MIN_VALUE;
		}
	}

    public static Boolean convertToBoolean(Object objValue, Boolean blnDefault) {
        try {
            if (objValue != null) {
                if (objValue instanceof Boolean) {
                    return (Boolean) objValue;
                } else if (objValue instanceof String) {
                    return Boolean.valueOf(addEmptyString(objValue));
                } else {
                    return "1".equals(addEmptyString(objValue));
                }
            }
        } catch (Exception ex) {
            return blnDefault;
        }
        return false;
    }

	public static Byte convertToByte(Object obj) {
		return convertToByte(obj,Byte.MIN_VALUE);
	}
	public static Byte convertToByte(Object obj, Byte bDefault) {
		try {
			if (obj == null)
				return bDefault;
			return Byte.parseByte(convertToString(obj));
		} catch (Exception ex) {
			return bDefault;
		}
	}

	public static Integer convertToInteger(Object obj, Integer iDefault) {
		try {
			if (obj == null)
				return iDefault;
			return Integer.parseInt(convertToString(obj));
		} catch (Exception ex) {
			return iDefault;
		}
	}

	public static float convertToFloat(Object obj, float fDefault) {
		try {
			return Float.parseFloat(StringUtility.clearNotNumber(convertToString(obj)));
		} catch (Exception ex) {
			return fDefault;
		}
	}

	public static Double convertToDouble(Object obj, Double dDefault) {
		try {
			return Double.parseDouble(StringUtility.clearNotNumber(convertToString(obj)));
		} catch (Exception ex) {
			return dDefault;
		}
	}

	public static Long convertToLong(Object obj) {
		try {
			return Long.parseLong(convertToString(obj));
		} catch (Exception ex) {
			return Long.MIN_VALUE;
		}
	}

	public static Long convertToLong(Object obj, Long lDefault) {
		try {
			return Long.parseLong(convertToString(obj));
		} catch (Exception ex) {
			return lDefault;
		}
	}

	public static Date convertToDate(Object obj, Date dDefault) {
		if (obj == null)
			return dDefault;
		String strSrc = addEmptyString(obj);
		if (StringUtility.isNullOrEmpty(strSrc))
			return dDefault;
		try {
			if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}\\:\\d{2}\\:\\d{2}\\.\\d{3}$", strSrc)) {
				// yyyy-MM-dd HH:mm:ss.SSS
				return string2Date(strSrc, DtFormatString);
			} else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}\\:\\d{2}\\:\\d{2}$", strSrc)) {
				// yyyy-MM-dd HH:mm:ss
				return string2Date(strSrc, DtFormatString_NoMillSecond);
			} else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", strSrc)) {
				// yyyy-MM-dd
				return string2Date(strSrc, DtFormatString_Date);
			}else if (Pattern.matches("^\\d+$", strSrc)) {
				// 毫秒
				return new Date(convertToLong(strSrc));
			}

			// public static final String DtFormatString_NoMillSecond =
			// "yyyy-MM-dd HH:mm:ss";
			// public static final String TimeFormatString_NoMillSecond = "MM-dd
			// HH:mm:ss";
			// public static final String DtFormatString_Date = "yyyy-MM-dd";
			// public static final String DtFormatString_yyyyMMddHHmmss =
			// "yyyyMMddHHmmss";
		} catch (Exception ex) {
		}
		return dDefault;
	}

	/**
	 * 长度为0的字符串
	 */
	public static final String Empty = "";

	/**
	 * 是否为null或空字符串
	 *
	 * @param strSrc
	 * @return
	 */
	public static Boolean isNullOrEmpty(String strSrc) {
		if (strSrc == null)
			return true;
		return strSrc.equalsIgnoreCase(StringUtility.Empty);
	}

	/**
	 * 过滤emoji字符
	 * @return a
	 * @Author panyun@youkeshu.com
	 * @Date 2018/9/10 15:04
	 */
	public static String clearEmoji(String strSrc){
		if (isNullOrEmpty(strSrc)) return strSrc;
		return strSrc.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", Empty);
	}

	private static SerializeConfig mapping = new SerializeConfig();
	private static String dateFormat;


	/**
	 * 对象序列化为JSON字符串
	 *
	 * @param objSrc
	 * @return
	 */
	public static String toJSONString(Object objSrc) {
		return JSON.toJSONString(objSrc, mapping);
	}
	/**
	 *   加上序列化属性的json 解析, 防止属性丢失
	 * @param
	 * @return
	 * @Author lwx
	 * @Date 2019/2/21 11:04
	 */
	public static String toJSONStringHasDefaultValues(Object objSrc) {
		if (objSrc == null) {return Empty;}
		return JSON.toJSONString(objSrc, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
	}

	public static String toJSONString_NoException(Object objSrc) {
		try {
			if (objSrc == null) return Empty;
			return JSON.toJSONString(objSrc, mapping);
		} catch (Exception ex) {
			log.error("toJSONString_NoException", ex);
			return Empty;
		}
	}

	public static <T> T parseObject(String strSrc, Class<T> t) {
		if (StringUtility.isNullOrEmpty(strSrc))
			return null;
		try {
			return JSON.parseObject(strSrc, t);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 追加空字符串，因为 null+""=="null"，所以重写
	 *
	 * @param str1
	 * @return
	 */
	public static String addEmptyString(String str1) {
		if (str1 == null)
			return Empty;
		return str1;
	}

	public static String addEmptyString(Object str1) {
		if (str1 == null)
			return Empty;
		return String.format("%s", str1.toString());
	}

	/**
	 * 不区分大小写相等判断
	 *
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static Boolean stringEqualsIgnoreCase(String str1, String str2) {
		return addEmptyString(str1).equalsIgnoreCase(addEmptyString(str2));
	}

	public static Boolean stringEqualsIgnoreCaseObj(Object str1, Object str2) {
		return addEmptyString(str1).equalsIgnoreCase(addEmptyString(str2));
	}

	/**
	 * 获取系统换行符
	 *
	 * @return
	 */
	public static String NewLine() {
		return System.getProperty("line.separator", "\r\n");
	}

	/**
	 * 拼接路径，左下斜杠，并删除前后斜杠
	 *
	 * @param arrPath
	 * @return
	 */
	public static String CombinePath(String... arrPath) {
		StringBuilder sbRslt = new StringBuilder();
		for (Integer i = 0; i < arrPath.length; i++) {
			String p = arrPath[i];

			sbRslt.append(trimPattern_Private(p, " /\\\\\\\\") + "/");
		}
		return trimPattern_Private(sbRslt.toString(), " \\/");
	}

	/**
	 * 拼接路径，左下斜杠，仅删除末尾斜杠
	 *
	 * @param arrPath
	 * @return
	 * @author PanYun 2015年10月15日 上午10:11:59
	 */
	public static String CombinePathV2(String... arrPath) {
		StringBuilder sbRslt = new StringBuilder();
		for (Integer i = 0; i < arrPath.length; i++) {
			String p = arrPath[i];
			if (StringUtility.isNullOrEmpty(p))
				continue;
			if (i == 0) {
				// 只删除末尾斜杠
				sbRslt.append(trimRightPattern_Private(p, " /\\\\\\\\") + "/");
			} else {
				sbRslt.append(trimPattern_Private(p, " /\\\\\\\\") + "/");
			}
		}
		return "" + trimRightPattern_Private(sbRslt.toString(), " \\/");
	}

	/**
	 * 检测是否有新版本 app
	 *
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static Integer compareVersion(String str1, String str2) {
		str1 = str1.replaceAll("[^\\d]", ""); // 非数字全部干掉
		str2 = str2.replaceAll("[^\\d]", "");
		return str1.compareToIgnoreCase(str2);
	}

	/**
	 * trim 前后指定字符
	 *
	 * @param strSrc
	 * @param strPattern
	 * @return
	 */
	public static String trimPattern_Private(String strSrc, String strPattern) {
		if (isNullOrEmpty(strSrc))
			return Empty;
		if (isNullOrEmpty(strPattern))
			return strSrc;
		return strSrc.replaceAll("(^[" + strPattern + "]+)|([" + strPattern + "]+$)", Empty);
	}

	/**
	 * trim 末尾指定字符
	 *
	 * @param strSrc
	 * @param strPattern
	 * @return
	 * @author PanYun 2015年10月15日 上午10:14:41
	 */
	public static String trimRightPattern_Private(String strSrc, String strPattern) {
		if (isNullOrEmpty(strSrc))
			return Empty;
		if (isNullOrEmpty(strPattern))
			return strSrc;
		return strSrc.replaceAll("([" + strPattern + "]+$)", Empty);
	}

	/**
	 * 添加字符串后再添加换行
	 *
	 * @param sb
	 * @param obj
	 */
	public static void sbAppendLine(StringBuilder sb, Object obj) {
		sb.append(obj);
		sb.append(StringUtility.NewLine());
	}

	public static void StringBufferAppendLine(StringBuffer sb, Object obj) {
		sb.append(obj);
		sb.append(StringUtility.NewLine());
	}

	/**
	 * 获取全小写的日期规则的guid
	 *
	 * @return
	 */
	public static String getGuidLowercase_Dt() {
		String strGuid = StringUtility.getGuidLowercase();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmm-ssSSS");// 设置日期格式

		String strDt = df.format(new Date());
		Integer iDtLength = strDt.length();

		StringBuilder sbRslt = new StringBuilder(strDt);
		sbRslt.insert(iDtLength - 1, "-");
		sbRslt.append(strGuid.substring(iDtLength + 1));
		return sbRslt.toString();
	}

	public static String getUUIDLowercase_Dt() {
		return StringUtility.guidToUUID(getGuidLowercase_Dt());
	}

	public static String getUUID() {
		return StringUtility.guidToUUID(StringUtility.getGuidLowercase());
	}

	/**
	 * 把byte转化成2进制字符串
	 *
	 * @param b
	 * @return
	 */
	public static String getBinaryStrFromByte(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			byte c = a;
			a = (byte) (a >> 1);// 每移一位如同将10进制数除以2并去掉余数。
			a = (byte) (a << 1);
			if (a == c) {
				result = "0" + result;
			} else {
				result = "1" + result;
			}
			a = (byte) (a >> 1);
		}

		// LogHelper.printlnDateTimeNow(result);
		return result;
	}

	private static String xor(String a, String b) {
		StringBuilder sbRslt = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			sbRslt.append(a.charAt(i) == b.charAt(i) ? "0" : "1");
		}
		return sbRslt.toString();
	}

	/**
	 * byte转成2进制字符串后，再异或
	 *
	 * @param arrB
	 * @author PanYun 2016年1月21日 下午6:50:23
	 */
	private static void xor1(byte[] arrB) {
		int idxStart = 0, idxEnd = arrB.length - 1;
		String rslt = getBinaryStrFromByte(arrB[idxStart]);
		int idx = idxStart + 1;
		while (idx <= idxEnd) {
			String strTmp = getBinaryStrFromByte(arrB[idx]);
			rslt = xor(rslt, strTmp);
			idx++;
		}

	}

	/**
	 * 转int后异或
	 *
	 * @param arrB
	 * @author PanYun 2016年1月21日 下午6:43:20
	 */
	public static byte xor2(byte[] arrB) {
		int idxStart = 0, idxEnd = arrB.length - 1;
		return xor2(arrB, idxStart, idxEnd);
	}

	/**
	 * 前一字节与后一字节异或的结果再与后一字节异或
	 *
	 * @param arrB
	 * @param idxStart
	 * @param idxEnd
	 * @return
	 * @author PanYun 2016年1月21日 下午6:47:18
	 */
	private static byte xor2(byte[] arrB, int idxStart, int idxEnd) {
		int rslt = arrB[idxStart];
		int idx = idxStart + 1;
		while (idx <= idxEnd) {
			int iTmp = arrB[idx];
			rslt = rslt ^ iTmp;
			idx++;
		}
		return (byte) rslt;
	}

	/**
	 * SHA1加密
	 *
	 * @param strSrc
	 * @return
	 */
	public static String EncryptSha1(String strSrc) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(strSrc.getBytes("UTF-8"));
			byte[] result = md.digest();
			StringBuffer sb = new StringBuffer();

			for (byte b : result) {
				int i = b & 0xff;
				if (i < 0xf) {
					sb.append(0);
				}
				sb.append(Integer.toHexString(i));
			}
			return sb.toString();
		} catch (Exception ex) {
		}
		return StringUtility.Empty;
	}

	/**
	 * 是否GUID
	 *
	 * @param strSrc
	 * @return
	 */
	public static Boolean isGuid(String strSrc) {
		if (StringUtility.isNullOrEmpty(strSrc))
			return false;
		// 20150629-0730-5666-6b51-1d80cc2479ee
		// ^\w{8}-(\w{4}-){3}\w{12}$
		return Pattern.matches("^\\w{8}-(\\w{4}-){3}\\w{12}$", strSrc);
	}

	public static Boolean isUuid(String strSrc) {
		if (StringUtility.isNullOrEmpty(strSrc))
			return false;
		// 20150629-0730-5666-6b51-1d80cc2479ee
		// ^\w{8}-(\w{4}-){3}\w{12}$
		return Pattern.matches("^\\w{32}$", strSrc);
	}

	/**
	 * 从0开始，截取指定长度
	 *
	 * @param strSrc
	 * @param
	 * @return
	 */
	public static String subString(String strSrc, Integer iLength) {
		if (isNullOrEmpty(strSrc))
			return Empty;
		if (iLength < 0)
			iLength = 0;
		if (iLength > strSrc.length())
			iLength = strSrc.length();
		return strSrc.substring(0, iLength);
	}

	/**
	 * 从末尾开始，截取指定长度
	 *
	 * @param strSrc
	 * @param iLength
	 * @return
	 * @author PanYun 2015年8月17日 上午11:27:49
	 */
	public static String subStringRight(String strSrc, Integer iLength) {
		if (isNullOrEmpty(strSrc))
			return Empty;
		if (iLength <= 0)
			return Empty;
		if (strSrc.length() - iLength < 0)
			return strSrc;
		return strSrc.substring(strSrc.length() - iLength);
	}

	public static String checkBlankString(String param) {
		if (param == null) {
			return "";
		}
		return param;
	}

	/**
	 * 报错，则原样返回
	 *
	 * @param encryptStr
	 * @return
	 * @author panyun 2017年3月7日 下午9:10:40
	 */
	public static String md5_NoException(String encryptStr) {
		try {
			return md5(encryptStr);
		} catch (Exception ex) {
			return Empty;
		}
	}

	public static String md5(String encryptStr) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(encryptStr.getBytes("UTF-8"));
		byte[] digest = md.digest();
		StringBuffer md5 = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
			md5.append(Character.forDigit((digest[i] & 0xF), 16));
		}

		encryptStr = md5.toString();
		return encryptStr;
	}

	public static String sha1(String encryptStr) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(encryptStr.getBytes("UTF-8"));
		byte[] digest = md.digest();
		StringBuffer sha1 = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			sha1.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
			sha1.append(Character.forDigit((digest[i] & 0xF), 16));
		}

		encryptStr = sha1.toString();
		return encryptStr;
	}

	public static byte[] md5Byte(String encryptStr) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(encryptStr.getBytes("UTF-8"));
		return md.digest();
	}

	public static byte[] sha1Byte(String encryptStr) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(encryptStr.getBytes("UTF-8"));
		return md.digest();
	}

	public static String genUUIDHexString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static UUID parseUUIDFromHexString(String hexUUID) throws Exception {
		byte[] data = hexStringToByteArray(hexUUID);
		long msb = 0;
		long lsb = 0;

		for (int i = 0; i < 8; i++)
			msb = (msb << 8) | (data[i] & 0xff);
		for (int i = 8; i < 16; i++)
			lsb = (lsb << 8) | (data[i] & 0xff);

		return new UUID(msb, lsb);
	}

	private static char convertDigit(int value) {

		value &= 0x0f;
		if (value >= 10)
			return ((char) (value - 10 + 'a'));
		else
			return ((char) (value + '0'));

	}

	/**
	 * 32个十六进制字符转成byte数组，每两个字符换算成一个byte
	 *
	 * @param s
	 * @return
	 */
	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	/**
	 * byte转16进制
	 *
	 * @param bytes
	 * @return
	 * @author PanYun 2016年1月21日 上午11:05:30
	 */
	public static String convert(final byte bytes[]) {

		StringBuffer sb = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			sb.append(convertDigit((int) (bytes[i] >> 4)));
			sb.append(convertDigit((int) (bytes[i] & 0x0f)));
		}
		return (sb.toString());

	}

	public static String convert(final byte bytes[], int pos, int len) {

		StringBuffer sb = new StringBuffer(len * 2);
		for (int i = pos; i < pos + len; i++) {
			sb.append(convertDigit((int) (bytes[i] >> 4)));
			sb.append(convertDigit((int) (bytes[i] & 0x0f)));
		}
		return (sb.toString());

	}

	/**
	 * 各个char转换为byte
	 *
	 * @param strUUID
	 * @return
	 * @author PanYun 2015年8月15日 下午4:41:57
	 */
	public static byte[] simpleToByte(String strUUID) {
		byte[] uuid = new byte[strUUID.length()];
		ByteBuffer buf = ByteBuffer.wrap(uuid);
		for (int i = 0; i < strUUID.length(); i++) {
			buf.put((byte) strUUID.charAt(i));
		}
		return uuid;
	}

	/**
	 * 各个byte转换为char
	 *
	 * @param arrByte
	 * @return
	 * @author PanYun 2015年8月15日 下午4:48:54
	 */
	public static String simpleToString(byte[] arrByte) {
		StringBuilder sbRslt = new StringBuilder();
		for (int i = 0; i < arrByte.length; i++) {
			sbRslt.append((char) arrByte[i]);
		}
		return sbRslt.toString();
	}

	public static byte[] getBytes(byte[] src, int pos, int len) {
		byte[] arrRslt = new byte[len];
		ByteBuffer buf = ByteBuffer.wrap(arrRslt);

		for (int i = pos; i < src.length && i < pos + len; i++) {
			buf.put(src[i]);
		}
		return arrRslt;

	}

	/**
	 * Guid转换为UUID,只是简单地去掉减号
	 *
	 * @param strGuid
	 * @return
	 * @author PanYun 2015年8月17日 上午11:02:26
	 */
	public static String guidToUUID(String strGuid) {
		if (StringUtility.isNullOrEmpty(strGuid))
			return strGuid;
		return strGuid.replace("-", StringUtility.Empty);
	}

	/**
	 * UUID转guid,只是简单地增加减号
	 *
	 * @param strUUId
	 * @return
	 * @author PanYun 2015年12月28日 下午2:37:06
	 */
	public static String uuidToGuid(String strUUId) {
		if (StringUtility.isNullOrEmpty(strUUId))
			return strUUId;
		if (strUUId.length() < 32)
			return strUUId;
		return strUUId.substring(0, 8) + "-" + strUUId.substring(8, 12) + "-" + strUUId.substring(12, 16) + "-" + strUUId.substring(16, 20) + "-" + strUUId.substring(20);
	}

	/**
	 * 验证字符是否手机号
	 *
	 * @param strCellphone
	 * @return
	 * @author PanYun 2015年8月27日 上午10:39:40
	 */
	public static Boolean isCellphone(String strCellphone) {
		if (StringUtility.isNullOrEmpty(strCellphone))
			return false;
		if (strCellphone.length() != 11)
			return false;

		return strCellphone.matches("^[1]\\d{10,10}$");
	}

	/**
	 * 是否全是数字
	 *
	 * @param strCellphone
	 * @return panyun 2016年7月19日下午2:11:15
	 */
	public static Boolean isNum(String strCellphone) {
		if (StringUtility.isNullOrEmpty(strCellphone))
			return false;

		return strCellphone.matches("^\\d+$");
	}

	/**
	 * 是否手表设备ID,15位数字
	 *
	 * @param strDeviceId
	 * @return
	 * @author PanYun 2015年12月24日 上午10:19:09
	 */
	public static Boolean isWatchDeviceId(String strDeviceId) {
		if (StringUtility.isNullOrEmpty(strDeviceId))
			return false;
		if (strDeviceId.length() != 15)
			return false;

		return strDeviceId.matches("^\\d{15,15}$");
	}

	/**
	 * 是否机器人设备ID,12位字符
	 *
	 * @param strDeviceId
	 * @return
	 * @author PanYun 2015年12月24日 上午10:19:09
	 */
	public static Boolean isRobotDeviceId(String strDeviceId) {
		if (StringUtility.isNullOrEmpty(strDeviceId))
			return false;
		if (strDeviceId.length() != 12)
			return false;

		return strDeviceId.matches("^[0-9a-zA-Z]{12,12}$");
	}

	/**
	 * 清除非数字字符，小数点除外
	 *
	 * @param strSrc
	 * @return
	 * @author PanYun 2015年11月28日 下午6:29:31
	 */
	public static String clearNotNumber(String strSrc) {
		if (StringUtility.isNullOrEmpty(strSrc))
			return Empty;
		StringBuilder sbRslt = new StringBuilder();
		for (int i = 0; i < strSrc.length(); i++) {
			if (strSrc.charAt(i) == '-' ||strSrc.charAt(i) == '.' || (strSrc.charAt(i) + Empty).matches("\\d?")) {
				sbRslt.append(strSrc.charAt(i));
			}
		}
		return sbRslt.toString();
	}

	public static String byteToStringUTF8(byte[] arrByte) {

		try {
			return new String(arrByte, "utf-8");
		} catch (Exception e) {
		}
		return StringUtility.Empty;
	}

	public static byte[] string2Byte(String strSrc) {
		try {
			if (StringUtility.isNullOrEmpty(strSrc))
				return new byte[0];
			return strSrc.getBytes("utf-8");
		} catch (Exception e) {
		}
		return new byte[0];
	}

	public static String getQueryString(String strQueryString, String strKey) {
		Map<String, String> mapQueryString = new HashMap<String, String>();
		String[] arrQueryString = strQueryString.split("\\&");
		for (String strMem : arrQueryString) {
			if (StringUtility.isNullOrEmpty(strMem))
				continue;
			String[] arrKeyValue = strMem.split("=");
			if (arrKeyValue == null || arrKeyValue.length != 2)
				continue;
			mapQueryString.put(arrKeyValue[0], arrKeyValue[1]);
		}
		return StringUtility.addEmptyString(mapQueryString.get(strKey));
	}

	/**
	 * 获取星期
	 *
	 * @param date
	 * @return
	 * @author PanYun 2016年1月5日 下午3:03:16
	 */
	public static int getWeek(Date date) {
		int[] arrInt = new int[] { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return arrInt[cal.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public static String myHtmlEncode(String strSrc) {
		strSrc = addEmptyString(strSrc);
		strSrc = strSrc.replaceAll("\"", "&quot;");
		strSrc = strSrc.replaceAll("<", "&lt;");
		strSrc = strSrc.replaceAll(">", "&gt;");
		return strSrc;
	}

	/**
	 * 数组加入分隔符
	 *
	 * @param userIds
	 * @param strSplit
	 * @return panyun 2017年3月7日下午8:09:22
	 */
	public static String arrJoin(String[] userIds, String strSplit) {
		if (userIds == null || userIds.length == 0)
			return StringUtility.Empty;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < userIds.length; i++) {
			if (i != 0) {
				sb.append(strSplit);
			}
			sb.append(userIds[i]);
		}
		return sb.toString();
	}

	public static double roundingNum(double d, int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("%.");
		sb.append(i);
		sb.append("f");
		String result = String.format(sb.toString(), d);
		return convertToDouble(result, d);
	}

	public static double roundingNumDouble(Double d, int i) {
		if (d == null)
			d = 0.00;
		return roundingNum(d.doubleValue(), i);
	}

	/**
	 * string 转json
	 *
	 * @param json
	 * @Author linwanxian@youkeshu.com
	 * @Date 2018/6/9 9:13
	 */
	public static JSONObject parseString(String json) {
		return JSONObject.parseObject(json);
	}

	/**
	 * json数组转list
	 *
	 * @param json
	 * @param classzz
	 * @Author linwanxian@youkeshu.com
	 * @Date 2018/6/9 9:13
	 */
	public static List jsonToList(String json, Class classzz) {
		List jsonList = JSON.parseArray(json, classzz);
		return jsonList;
	}

	/**
	 * stirng 转date
	 *
	 * @param strDate
	 * @param dateFormat
	 * @Author linwanxian@youkeshu.com
	 * @Date 2018/6/9 17:25
	 */
	public static Date stringToDate(String strDate, String dateFormat) throws ParseException {
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		date = simpleDateFormat.parse(strDate);
		return date;
	}

	public static Map ConvertObjToMap(Object obj) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					reMap.put(fields[i].getName(), o);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage(), e);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage(), e);
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
		}
		return reMap;
	}

	/**
	 * 计算时间 (30)
	 *
	 * @param
	 * @return
	 * @Author lwx
	 * @Date 2018/11/20 14:35
	 */
	public  static Date calendarDates(Long date, Integer days, Integer type) {
		if (date == null || days == null) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		//将时间戳转化为时间
		Date dateTime = new Date(date);
		calendar.setTime(dateTime);
		//type  1 增加  0 减少
		if (type == 1) {
			calendar.add(Calendar.DAY_OF_YEAR, +days);
		} else {
			calendar.add(Calendar.DAY_OF_YEAR, -days);
		}
		String resultTime = simpleDateFormat.format(calendar.getTime());
		try {
			return simpleDateFormat.parse(resultTime);
		} catch (ParseException e) {
			log.error("[calendarDates] date conversion exception", e);
			return null;
		}
	}


	public static String md5NoException(String src) {
		try {
			if (isNullOrEmpty(src)) return Empty;
			return md5(src);
		} catch (Exception ex) {
			log.error(String.format("MD5:%s", src), ex);
			return Empty;
		}
	}


	/**
	 * unicode 转字符串
	 * @param unicode
	 * @return
	 */
	public static String unicode2String(String unicode){
		if(isNullOrEmpty(unicode)){
			return null;
		}
		try{
			unicode = unicode.replaceAll("\u001A", "");
			StringBuilder sb = new StringBuilder();
			int i = -1;
			int pos = 0;
			while((i=unicode.indexOf("\\u", pos)) != -1){
				sb.append(unicode.substring(pos, i));
				if(i+5 < unicode.length()){
					pos = i+6;
					sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));
				}
			}
			if(pos < unicode.length()){
				sb.append(unicode.substring(pos, unicode.length()));
			}
			return sb.toString();
		}catch (Exception ex){
			log.error("Transfer unicode string error", ex);
		}
		return unicode;
	}
	/**
	 *  java 8  long 型时间 格式化字符串
	 * @param
	 * @return
	 * @Author lwx
	 * @Date 2019/4/17 14:48
	 */
	public  static String convertLongDateToString(Long dateTime,String format){
		if (dateTime == null || StringUtils.isEmpty(format)) {
			return null;
		}
		// 精确到毫秒
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern(format);
		return formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTime),ZoneId.systemDefault()));
	}
	/**
	 *   java 8 字符串转时间
	 * @param
	 * @return
	 * @Author lwx
	 * @Date 2019/4/25 17:47
	 */
	public static Long convertStringToDateTime(String dataTimeStr,String format){
		if (StringUtils.isEmpty(dataTimeStr) || StringUtils.isEmpty(format)) {
			return null;
		}
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern(format);
		LocalDateTime parse =LocalDateTime.parse(dataTimeStr,formatter);
		return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	public static BigDecimal addEmptyBigDecimal(BigDecimal bigDecimal) {
		try {
			if(bigDecimal == null){
				return BigDecimal.ZERO;
			}
			return bigDecimal;
		} catch (Exception ex) {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * 从根节点解析bean
	 *
	 * @param jsonParam json字符串
	 * @param rootName  根节点名称
	 * @param <T>
	 * @return
	 */
	public static <T> T parseJsonToBean(String jsonParam, String rootName, Class<T> t) {
		try {
			JSONObject reqJSONObject = JSONObject.parseObject(jsonParam);
			String reqData = reqJSONObject.get(rootName).toString();
			return parseObject(reqData, t);

		} catch (Exception ex) {
			return null;
		}
	}



	public static void main(String[] args) {
		System.out.println(StringUtility.convertLongDateToString(1551715199000L,"yyyy-MM-dd HH:mm:ss"));
		System.out.println(StringUtility.convertStringToDateTime("2019-03-04 23:59:59","yyyy-MM-dd HH:mm:ss"));
	}

	public static int sum(Integer... args) {
		if (args == null) {
			return 0;
		}
		int rslt = 0;
		for (int i = 0; i < args.length; i++) {
			rslt += (args[i] == null ? 0 : args[i].intValue());
		}
		return rslt;
	}

	/**
	 * 去除富文本编辑器标签
	 * @author djinfeng
	 * @param inputString
	 * @return
	 */
	public static String removeHtmlTag(String inputString) {
		if (inputString == null)
			return null;
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		java.util.regex.Matcher m_script;
		Pattern p_style;
		java.util.regex.Matcher m_style;
		Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			//定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			//定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(" "); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textStr;// 返回文本字符串
	}
}