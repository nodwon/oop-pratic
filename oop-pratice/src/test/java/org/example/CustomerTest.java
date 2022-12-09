package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ���������� ���� �ֹ��ϴ� ��������
 * �䱸����
 * 1. �������� �����ϴ� ��ü���� ��͵��� �ִ��� ���
 *      �մ�, �޴���, ���/ �ø�, ����, �丮��,�丮
 * 2. ��ü�� ���� ������
 *      �մ� -- �޴���
 *      �մ� -- �丮��
 *      �丮�� -- �丮
 * 3. ������ ��ü�� ������ Ÿ������ �߻�ȭ�Ͽ� ������ �𵨸��ϱ�
 *      �մ� -- �մ�Ÿ��
 *      ��� �ø� ���� -- �丮Ÿ��
 *      �޴��� -- �޴���Ÿ��
 *      �޴� -- �޴� Ÿ��
 * 4. ������ ����
 * 5. ��ü���� �����ϴ� Ÿ�Կ� ������ å���� �Ҵ�
 * 6. �����ϱ�
 */
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CustomerTest {
    @DisplayName("�޴��̸��� �ذ��ϴ� �丣�� �ֹ��Ѵ�.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new Menuitem("���",5000), new Menuitem("�ø�",7000)));
        Cooking cooking = new Cooking();
        assertThatCode(() -> customer.order("����",  menu, cooking))
                .doesNotThrowAnyException();


    }
}
