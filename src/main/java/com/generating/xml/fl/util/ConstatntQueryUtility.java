package com.generating.xml.fl.util;

public class ConstatntQueryUtility {

    public static String QUERY_SEARCH_BY_EMAIL= "select a.id,a.active,a.blocked, a.email, a.email, a.user_name," +
            "       d.id, d.device_name,d.msisdn " +
            "from device d join account a on d.account_id = a.id " +
            "where (a.user_name = ? or a.email = ?) and d.active = true";

    public static String QUERY_DEVICE_USER_BY_EMAIL_ACTIVE = "select a.id as account_id, a.email, a.user_name, " +
            "d.id as device_id, d.device_name,d.msisdn, d.imei, d.os " +
            "from device d join account a on d.account_id = a.id " +
            "where (a.user_name = ? or a.email = ?)";

    public static String QUERY_CUSTOMER_BY_IDENTIFICATION_NUMBER= "select i.id, i.status status_ident, m.msisdn, m.status status_clien, " +
            "       m.isprimary, pt.partner_name as Telco " +
            "from r_gcscustomer_account_m i " +
            "inner join pre_gcscustomer_enrollment_m m on (i.gcs_account_id=m.gcs_Account_id) " +
            "inner join partner_m pt on (m.telco_code=pt.partner_code) " +
            "where id= ?";

    public static String QUERY_DAILY_TRANSACTION= "SELECT ft.msisdn, " +
            "    a.id, " +
            "    ft.transaction_date, " +
            "    tm.transaction_id, " +
            "    ft.sub_transaction_type, " +
            "    m.sub_transaction_name, " +
            "    ft.request_type, " +
            "    ft.amount, " +
            "    ft.account_number as Cuenta_bancaria, " +
            "    tm.status, " +
            "    ft.response_code, " +
            "    CASE WHEN ft.transaction_type = '02' THEN bill.customer_identifier " +
            "        WHEN ft.transaction_type = '03' THEN cast(ft2.msisdn as text) " +
            "        WHEN ft.transaction_type = '04' THEN ac.card_acptr_name_loc " +
            "        ELSE cast(ft.msisdn as text) END cuenta_receptora_credito, " +
            "    CASE WHEN ft.transaction_type = '01' THEN ft.partner_code " +
            "        WHEN ft.transaction_type = '02' THEN bill.partner_code " +
            "        WHEN ft.transaction_type = '03' THEN ft2.partner_code " +
            "        WHEN ft.transaction_type = '04' THEN ac.partner_code " +
            "        WHEN ft.transaction_type = '05' THEN ft2.partner_code " +
            "        ELSE ft.partner_code END socio_receptor_credito, " +
            "    CASE WHEN ft.transaction_type = '01' THEN cast(ft.partner_code as text) " +
            "        WHEN ft.transaction_type = '02' THEN  cast(bill.billrefrenceno as text) " +
            "        WHEN ft.transaction_type = '03' THEN ft2.bp_sequenceno " +
            "        ELSE cast(ft.partner_code as text) END Autorizacion_Credito, " +
            "    CASE WHEN ft.transaction_type = '01' AND top.topupstatus = 'F' THEN 'S' " +
            "        WHEN ft.transaction_type = '02' AND bill.status = 'F' THEN 'S' " +
            "        WHEN ft.sub_transaction_type = '0339' AND bill.status = 'F' THEN 'S' " +
            "        WHEN (ft.sub_transaction_type IN ('0409', '0410')) AND bill.status = 'F' THEN 'S' " +
            "        WHEN ft.transaction_type = '04' AND ac.status = 'F' THEN 'S' " +
            "        WHEN ft2.status = 'F' THEN 'S' " +
            "        WHEN tm.status = 'F' THEN 'S' " +
            "        ELSE '-' END AS incomplete " +
            "    FROM ft_transfer_t_o ft " +
            "    INNER JOIN transaction_m tm ON (ft.gcs_sequenceno = tm.gcs_Sequenceno)" +
            "    LEFT JOIN r_gcscustomer_account_m a ON (a.gcs_account_id = ft.gcs_account_id) " +
            "    LEFT JOIN FT_TRANSFER_T_o ft2 ON (ft.GCS_SEQUENCENO = ft2.GCS_SEQUENCENO AND ft2.REQUEST_TYPE = 'CR') " +
            "    INNER JOIN m_sub_transaction_types_mp m ON (ft.sub_transaction_type = m.sub_transaction_code) " +
            "    LEFT JOIN ft_topup_t_o top ON (ft.gcs_sequenceno = top.gcs_sequenceno AND ft.request_type = 'DR')" +
            "    LEFT JOIN bill_payement_l bill ON (ft.gcs_Sequenceno = bill.gcs_Sequenceno AND ft.request_type = 'DR') " +
            "    LEFT JOIN FT_AQUIRER_T_O ac ON (ft.GCS_SEQUENCENO = ac.GCS_SEQUENCENO AND ft.REQUEST_TYPE = 'DR') where ft.msisdn = '8296386677' order by ft.transaction_date desc LIMIT 10";
}
