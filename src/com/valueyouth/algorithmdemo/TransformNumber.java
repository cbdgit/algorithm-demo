package com.valueyouth.algorithmdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformNumber
{
	/**��д��������**/
    private final static String[] UPPER_NUMBER = {"��","һ","��","��","��","��","��","��","��","��"};

    /**��λ**/
    private final static String[] UNIT_NUMBER = {"", "ʮ", "��", "ǧ", "��", "ʮ", "��", "ǧ", "��", "ʮ", "��", "ǧ"}; 

    
    public static void main(String[] args) 
    {
        TransformNumber transformNumber = new TransformNumber();
        
        String number = "100001000"; // ����������ַ���
        
        System.out.println(transformNumber.transformToUpperNumber(number));
    }
    
    /**
     * ����˵������Сд����ת���ɴ�д���֡�
     * @param number ԴСд�����ַ���
     * @return Ŀ�������д����
     */
    private String transformToUpperNumber(String number)
    {
    	StringBuffer outNumber = new StringBuffer(); // ������������ַ���
    	boolean prePositionZero = true; // ǰһ���ַ��Ƿ�����
    	number = preHandleToNumber(number); // Ԥ���������ַ���
    	int length = number.length();
    	
    	for (int i = length - 1; i >= 0; i--) // �Ӹ�λ��ʼ����
    	{
    		int properIndex = length - i - 1; // �Ӹ�λ��ʼ
    		if (0 == properIndex % 4) // ��λ������λ����λ��Ϊ��
    		{
    			/*�����λ����λ����λ����ǧλ��ǧ���ǧ�ڣ���Ϊ��*/
    			if (i - 4 >= 0 && "0000".equals(number.substring(i - 3, i + 1)))
    			{
    				if (!prePositionZero)
    				{
    					outNumber.insert(0, UPPER_NUMBER[0]); // ����Ϊ��
    					prePositionZero = true;
    				}
    				
    				i -= 3; // �������¼�4����λ������i--��
    				continue;
    			}
    			
    			prePositionZero = true;
    		}
    		
    		int singleNum = getSingleNum(number, i); // ��ǰ������Ӧ�ĵ�������
    		if (0 == singleNum)
    		{
    			if (!prePositionZero) // ��ǰΪ����ǰһλ��Ϊ�㣬������Ϊ��
    			{
    				outNumber.insert(0, UPPER_NUMBER[0]); // ����Ϊ��
    				prePositionZero = true; // ��λ���������㣨��һ�ַ���ǰһλ��
    			}
    			
    			if (0 == (properIndex) % 4) // ��ǰλΪ�㣬������λ�����ڣ��ϣ����õ�λ
    			{
    				outNumber.insert(0, UNIT_NUMBER[properIndex]);
    			}
    		}
    		else
    		{
    			outNumber.insert(0, UPPER_NUMBER[singleNum] + UNIT_NUMBER[properIndex]);
    			prePositionZero = false; // ��һ�ַ�ǰһλ��Ϊ��
    		}
    	}
    	
    	return outNumber.toString();
    }
    
    /**
     * ����˵������������ַ�������Ԥ����
     * @param number ����������ַ���
     * @return �����������ַ���
     * @throws Exception ��������Χ���׳��쳣
     */
    private String preHandleToNumber(String number)
    {
    	number = number.replaceAll("^(0+)", ""); // ����ǰ��������
    	if (!isNumber(number) || number.length() > 12) // ����Χ�����
    	{
    		try
    		{
				throw new Exception("��������Χ�����������룡");
			} 
    		catch (Exception e)
    		{
				e.printStackTrace();
			}
    	}
    	
    	return number;
    }
    
    /**
     * ����˵�������������ַ����Ƿ������֡�
     * @param number Դ�ַ���
     * @return true��������������ַ��������򣬷���false
     */
    private boolean isNumber(String number)
    {
    	Pattern pattern = Pattern.compile("[0-9]*");
    	Matcher matcher = pattern.matcher(number);
    	
    	if (matcher.matches())
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * ����˵�����õ�ָ�������������ַ�����ת�����ͷ���
     * @param number Դ�����ַ���
     * @param index �ַ�������
     * @return ָ��������������
     */
    private int getSingleNum(String number, int index)
    {
    	return Integer.parseInt(number.substring(index, index + 1));
    }
}
