package cn.young22.dsa.ch05;

import cn.young22.dsa.ch06.LinkedStack;

/** �����ʽ�Ƿ�ƽ�����
 * 	��һ����׺���ʽ�У��������ɶԳ��֣����޽���ʹ�ã���˵���ʽ��ƽ���
 *  ���������ǳɶԳ��ֵĻ������н���ʹ�ã���˵����׺���ʽ�ǲ�ƽ���
 *  ����ʹ��ջ�����Ĺ�����������׺���ʽ�Ƿ�ƽ������ж�
 * */
public class BalanceChecker {
	/** �����ʽƽ�ⷽ��*/
	public static boolean checkBalance(String expression){
		// ����һ��LinkedStack���͵Ķ��󣬽��丳ֵ��StackInterface<Character>���͵ı���openDelimiterStack
		StackInterface<Character> openDelimiterStack = new LinkedStack<>();
		
		int characterCount = expression.length();	// ʹ���ַ�����.length������ñ��ʽ�ĳ���
		boolean isBalanced = true;					// �����ʽ���Ե�ƽ���ʶ����Ϊtrue
		int index = 0;								// ѭ�������±�
		char nextCharacter = ' ';					// ��ʼ��nextCharcterΪ ' '
		
		// �����ʽΪƽ�����±���Ʒ�indexС���ַ����ĳ���ʱ������ѭ��
		// ���жϳ����ʽ��ƽ��, �����ѭ��
		// ���±���Ʒ�index��С��characterCount,
		// ��˵�����ʽ������û�н���ʹ�ã�����ѭ��
		// ��Ҫ��һ���ж�ջ���Ƿ����ַ����жϱ��ʽ�Ƿ���ƽ���
		while(isBalanced && (index < characterCount)){
			// ͨ��indexÿ��ȡһ���ַ������ж�
			nextCharacter = expression.charAt(index);
			// ʹ��switch case���������
			switch(nextCharacter){
			case '(': case '[': case '{':
				// ���ַ�Ϊ ( [ {, �򽫸��ַ�ѹ��ջ,Ȼ�����ж���һ���ַ�
				openDelimiterStack.push(nextCharacter);
				break;
			case ')': case ']': case '}':
				// ���ַ�Ϊ ) ] }, �����ж���һ��case�е�ջ�Ƿ�Ϊ�գ���Ϊ�գ���˵�����ʽ�ǲ�ƽ���
				if(openDelimiterStack.isEmpty()){
					isBalanced = false;
				}
				// ��ջ��Ϊ�գ���ջ�е��ַ���ѹ������ֵ��һ���±���openDelimiter
				// ʹ��isPaired�����Ƚ������ַ��Ƿ�����Ե�
				else{
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = isPaired(openDelimiter, nextCharacter);
				}
				break;
			} //end switch
			index++;
		}//end while
		
		// ͨ��ѭ�������������ַ����ٿ�ջ���Ƿ����ַ����������ַ���˵�����ʽ�ǲ�ƽ���
		if(!openDelimiterStack.isEmpty()){
			isBalanced = false;
		}
		// ���ر��ʽ�Ƿ�ƽ��Ľ��
		return isBalanced;	
	}
	
	/** ���ջ��pop�������ַ��Ƿ�����һ���ַ�ƥ��ķ���*/
	private static boolean isPaired(char open, char close){
		return(open == '(' && close == ')' ||
				open == '[' && close == ']' ||
				open == '{' && close == '}');
	}//end isPaired
}
