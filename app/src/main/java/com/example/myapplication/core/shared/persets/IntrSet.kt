package com.example.myapplication.core.shared.persets

import android.content.Context
import java.util.Date

const val SET_SHOW_SIALOG: String = "SET_SHOW_DIALOG"
const val LATITUDE: String = "LATITUDE"
const val LONGITUDE: String = "LONGITUDE"
const val ID_LOCAL: String = "IDLOCAL"
const val PERSET_ID_COL: String = "PERSETIDCOL"
const val INTR_DESC: String = "INTRDESC"
const val SHOW_MSG_DISC: String = "SHOWMSGDISC"
const val CLEAR_BASE_DATE: String = "CLEARBASEDATE"
const val ID_FROM_PRICE_TABLE: String = "IDFROMPRICETABLE"
const val PASS: String = "PASS"
const val PFILTERSITUATION: String = "PFILTERSITUATION"
const val DESC_FIELD_NOT_PERCENT: String = "DESCFIELDNOTPERCENT"
const val DESC_SALESORDER_BY_NOT_PERCENT: String = "DESCSALESORDERBYNOTPERCENT"
const val SELECTED_PRODUCT: String = "SELECTEDPRODUCT"
const val PARAMETER_SITUATION: String = "PARAMETERSITUATION"
const val SELECTED_BEGIN: String = "SELECTED_BEGIN"
const val SELECTED_END: String = "SELECTED_END"
const val SELECTED_CLIENT: String = "SELECTED_CLIENT"
const val SELECTED_CLIENT_TO_RULES: String = "SELECTED_CLIENT_TO_RULES"
const val LAST_SELECTED_CLIENT: String = "LAST_SELECTED_CLIENT"
const val SELECTED_PRICE_TABLE: String = "SELECTED_PRICE_TABLE"
const val SELECTED_SUBGROUP: String = "SELECTED_SUBGROUP"
const val SELECTED_COLLECTION: String = "SELECTED_COLLECTION"
const val SELECTED_REPRESENTATIVE: String = "SELECTED_REPRESENTATIVE"
const val SALES_ORDER_EDITING: String = "SALES_ORDER_EDITING"
const val SALES_ORDER_DIVIDED_ITEMS: String = "SALES_ORDER_DIVIDED_ITEMS"
const val EXPORT_SALES_ORDER_EDITING: String = "EXPORT_SALES_ORDER_EDITING"
const val TITLES_SITUATION_FILTER: String = "TITLES_SITUATION_FILTER"
const val SALES_ORDER_EMISSION_FILTER: String = "SALES_ORDER_EMISSION_FILTER"
const val CLIENT_POSITIVATION_FILTER: String = "CLIENT_POSITIVATION_FILTER"
const val NOTIFY_POSITIVATION_FILTER: String = "NOTIFY_POSITIVATION_FILTER"
const val CLIENT_CONTACT_WAS_EDITED: String = "CLIENT_CONTACT_WAS_EDITED"
const val SALES_ORDER_ITEMS_LIST_EDITING: String = "SALES_ORDER_ITEMS_LIST_EDITING"
const val EXPORT_SALES_ORDER_ITEMS_LIST_EDITING: String = "EXPORT_SALES_ORDER_ITEMS_LIST_EDITING"
const val SALES_ORDER_SHOW_YELLOW_TOAST: String = "SALES_ORDER_SHOW_YELLOW_TOAST"
const val FITTING_VIEW_EDITING_LOOK: String = "FITTING_VIEW_EDITING_LOOK"
const val MODEL_SELECTED: String = "SELECTED_MODEL"
const val LOOK_COMPOUND_SELECTED: String = "SELECTED_LOOK_COMPOUND"
const val IS_ADDING_ITEMS: String = "IS_ADDING_ITEMS"
const val SYNCING_HISTORY_COUNTER: String = "SYNCING_HISTORY_COUNTER"
const val SHOW_REPRESENTATIVES: String = "SHOW_REPRESENTATIVES"
const val FRESH_COMMISSION: String = "FRESH_COMMISION"
const val GETEAN: String = "GET_EAN"
const val GETEANBYBARCODE: String = "GETEANBYBARCODE"
const val GETEANAUTO: String = "GET_EAN_AUTO"
const val CLIENT_CONTACT_EDITING: String = "CLIENT_CONTACT_EDITING"
const val USE_FAKE_ITEM: String = "USEFAKEITEM"
const val ID_PAYMENT_CONDITION: String = "IDPAYMENTCONDITION"
const val ID_SALES_TYPE: String = "IDSALESTYPE"
const val MEDIUM_TIME: String = "MEDIUMTIME"
const val ID_REDISPATCH_CARRIER: String = "IDREDISPATCHCARRIER"
const val LAST_ID_PAYMENT_CONDITION: String = "LASTIDPAYMENTCONDITION"
const val BALANCE_STATUS_VALUE: String = "BALANCESTATUSVALUE"
const val PRICE_BY_SALESTYPE: String = "PRICEBYSALESTYPE"
const val PASS_THROUGH_NOT_DISCOUNT_FIELD: String = "PASSTHROUGHNOTDISCOUNTFIELD"
const val ID_TO_DUPLICATE: String = "IDTODUPLICATE"
const val ALERT_TO_OPEN_SALES: String = "ALERTTOOPENSALES"
const val VALIDATE_STOCK: String = "VALIDATESTOCK"
const val PRODUCT_FROM_GRID: String = "PRODUCTFROMGRID"
const val MULTI_PACK: String = "MULTIPACK"
const val ID_COLOR_TO_FIXED_AS_ALTERNATIVE_PACKS: String = "IDCOLORTOFIXEDASALTERNATIVEPACKS"
const val SYNC_ONLY_COLORS: String = "SYNCONLYCOLORS"
const val CLEAR_SORTMENT: String = "CLEARSORTMENT"
const val PRODUCT_LINE: String = "PRODUCTLINE"
const val DUPLICATE_SALE: String = "SALETODUPLICATE"
const val DUPLICATE_SALE_ITEMS: String = "SALEITEMSTODUPLICATE"
const val ADDING_VALUE: String = "ADDINGVALUE"
const val CODE_CLIENT: String = "CODECLIENTS"
const val ID_ADDITION: String = "IDADDITION"
const val WAS_SETTED_BY_ALTERNATIVE_PACK: String = "WAS_SETTED_BY_ALTERNATIVE_PACK"
const val CHECK_PASS_THROUG_EAN: String = "CHECKPASSTHROUGEAN"
const val STOCK_WAS_RETURN: String = "STOCKWASRETURN"


class IntrSet(context: Context) : RootSet(context) {

    private val context: Context = context

    fun wasSettedByAlternativePack(wasSetted: Boolean) {
        editor.putBoolean(WAS_SETTED_BY_ALTERNATIVE_PACK, wasSetted).commit()
    }

    fun getWasSettedByAlternativePack(): Boolean {
        return prefs.getBoolean(WAS_SETTED_BY_ALTERNATIVE_PACK, false)
    }

    fun setAddingValue(value: Float) {
        editor.putFloat(ADDING_VALUE, value).commit()
    }

    fun getAddingValue(): Float {
        return prefs.getFloat(ADDING_VALUE, 0.0f)
    }

    fun setCodeClients(code: String) {
        editor.putString(CODE_CLIENT, code.toString()).commit()
    }

    fun getCodeClients(): String? {
        return prefs.getString(CODE_CLIENT, "")
    }


    fun setIdToDuplicate(id: Int) {
        editor.putInt(ID_TO_DUPLICATE, id)
    }

    fun getIdToDuplicate(): Int {
        return prefs.getInt(ID_TO_DUPLICATE, 0)
    }

    fun setIsAdding(v: Boolean) {
        editor.putBoolean(IS_ADDING_ITEMS, v).commit()
    }

    fun isAdding(): Boolean {
        return prefs.getBoolean(IS_ADDING_ITEMS, false)
    }

    /* public EProductModules getLastProductModuleVisited() {
        int i = getPrefs().getInt(LAST_PRODUCT_LIST_MODULE_VISITED, -1);

        if (i == -1) {
            String[] modules = PerSet.get(getContext()).getBranch().getModulesArray();
            if (modules.length > 0) {
                i = Formats.parseInt(modules[0], 0);
                setLastProductModuleVisited(i);
            } else {
                return EProductModules.getDefaultValue();
            }
        }

        return EProductModules.getEnum(i);
    }*/
    /*   public void setLastProductModuleVisited(int i) {
        putInt(LAST_PRODUCT_LIST_MODULE_VISITED, i);
    }*/
    fun getCheckPassThrougEan(): Boolean {
        return prefs.getBoolean(CHECK_PASS_THROUG_EAN, true)
    }

    fun setCheckPassThrougEan(pass: Boolean) {
        editor.putBoolean(CHECK_PASS_THROUG_EAN, pass).commit()
    }

    fun getShowYellowQuestionToast(): Boolean {
        return prefs.getBoolean(SALES_ORDER_SHOW_YELLOW_TOAST, true)
    }

    fun setShowYellowQuestionToast(show: Boolean) {
        editor.putBoolean(SALES_ORDER_SHOW_YELLOW_TOAST, show).commit()
    }

    //todo implementar getSelectedClient
    /*fun getSelectedClient(): Client {
        return ClientDAO(getContext()).select(getSelectedClientId())
    }*/

    fun getStatus(): Int {
        return prefs.getInt(BALANCE_STATUS_VALUE, 0)
    }

    fun setStatus(value: Int) {
        editor.putInt(BALANCE_STATUS_VALUE, value).commit()
    }

    //todo implementar getSelectedClientByRules
    /*fun getSelectedClientByRules(): Client {
        return ClientDAO(getContext()).select(getSelectedClientIdByRules())
    }*/

    fun getSelectedClientId(): Int {
        return if (prefs != null) {
            prefs.getInt(SELECTED_CLIENT, 0)
        } else {
            0
        }
    }

    fun setSelectedClient(idClient: Int) {
        if (getSelectedClientId() != idClient) {
            putInt(SELECTED_CLIENT, idClient)
        }
    }

    fun setPersetIdCol(idCol: Int) {
        putInt(PERSET_ID_COL, idCol)
    }

    fun getPersetIdCol(): Int {
        return prefs.getInt(PERSET_ID_COL, 0)
    }

    fun setMsgDisc(v: Boolean) {
        putBoolean(SHOW_MSG_DISC, v)
    }

    fun getMsgDisc(): Boolean {
        return prefs.getBoolean(SHOW_MSG_DISC, false)
    }

    fun setclearBaseDate(v: Boolean) {
        putBoolean(CLEAR_BASE_DATE, v)
    }

    fun getclearBaseDate(): Boolean {
        return prefs.getBoolean(CLEAR_BASE_DATE, false)
    }

    fun setIntrDesc(desc: Int) {
        putInt(INTR_DESC, desc)
    }

    fun getIntrDesc(): Int {
        return prefs.getInt(INTR_DESC, 0)
    }

    fun showDialogToCheckIn(`val`: Boolean) {
        putBoolean(SET_SHOW_SIALOG, `val`)
    }

    fun getShowDialogToCheckIn(): Boolean {
        return prefs.getBoolean(SET_SHOW_SIALOG, true)
    }

    //-------------------------------------------------//
    fun putIdLocal(`val`: Int) {
        putInt(ID_LOCAL, `val`)
    }

    fun getIdLocal(): Int {
        return prefs.getInt(ID_LOCAL, 0)
    }

    //-------------------------------------------------//
    fun setSelectedClientToRules(idClient: Int) {
        if (getSelectedClientId() != idClient) {
            putInt(SELECTED_CLIENT_TO_RULES, idClient)
        }
    }

    fun getSelectedClientIdByRules(): Int {
        return prefs.getInt(SELECTED_CLIENT_TO_RULES, 0)
    }

    fun setSelectedRedispatch(idRedispatch: Int) {
        putInt(ID_REDISPATCH_CARRIER, idRedispatch)
    }

    fun getSelectedRedispatch(): Int {
        return getInt(ID_REDISPATCH_CARRIER)
    }

    fun setIdPaymentCondition(idPaymentCondition: Int) {
        putInt(ID_PAYMENT_CONDITION, idPaymentCondition)
    }

    fun setMediumTime(mediumTime: String?) {
        putString(MEDIUM_TIME, mediumTime!!)
    }

    fun setLastPaymentCondition(idPaymentCondition: Int) {
        putInt(LAST_ID_PAYMENT_CONDITION, idPaymentCondition)
    }

    fun getIdPaymentCondition(): Int {
        return getInt(ID_PAYMENT_CONDITION)
    }

    fun getLastIdPaymentCondition(): Int {
        return getInt(LAST_ID_PAYMENT_CONDITION)
    }

    fun setSelectedBegin(date: Date?) {
        putDate(SELECTED_BEGIN, date!!)
    }

    fun getSelectedBegin(): Date {
        return getDate(SELECTED_BEGIN)
    }

    fun setSelectedEnd(date: Date?) {
        putDate(SELECTED_END, date!!)
    }

    fun getSelectedEnd(): Date {
        return getDate(SELECTED_END)
    }

    /*fun getSelectedPriceTable(): PriceTable? {
        return PriceTableDAO(context).select(
            getPrefs().getInt(
                IntrSet.SELECTED_PRICE_TABLE,
                0
            )
        )
    }*/

    /*fun getSelectedSubGroup(): SubGroup {
        return SubGroupDAO(context).select(getPrefs().getInt(IntrSet.SELECTED_SUBGROUP, 0))
    }*/

    //-----------------------------------------------------------------//
    fun getPriceBySalestype(): String? {
        return getString(PRICE_BY_SALESTYPE, "")
    }

    fun getMediumTime(): String? {
        return if (getString(MEDIUM_TIME, "").equals("")) {
            "0"
        } else {
            getString(MEDIUM_TIME, "")
        }
    }

    fun setPriceBySalestype(type: String?) {
        putString(PRICE_BY_SALESTYPE, type!!)
    }

    //-----------------------------------------------------------------//
    fun setSelectedPriceTable(idPriceTable: Int) {
        editor.putInt(SELECTED_PRICE_TABLE, idPriceTable).commit()
    }

    fun setSelectedSubGroup(idSubGroup: Int) {
        editor.putInt(SELECTED_SUBGROUP, idSubGroup).commit()
    }

    /*fun getSelectedCollection(): Collection {
        return CollectionDAO(getContext()).select(getSelectedCollectionId())
    }*/

    fun getSelectedCollectionId(): Int {
        return prefs.getInt(SELECTED_COLLECTION, 0)
    }

    /*fun getSelectedRepresentative(): Representative {
        return RepresentativeDAO(getContext()).select(getSelectedRepresentativeId())
    }*/

    fun getSelectedRepresentativeId(): Int {
        return prefs.getInt(SELECTED_REPRESENTATIVE, 0)
    }

    fun setSelectedRepresentative(idRepresentantive: Int) {
        if (getSelectedRepresentativeId() != idRepresentantive) {
            putInt(SELECTED_REPRESENTATIVE, idRepresentantive)
        }
    }

    fun setSelectedCollection(idCollection: Int) {
        putInt(SELECTED_COLLECTION, idCollection)
    }

    /*fun setSalesOrderEditing(salesOrder: SalesOrder?) {
        editor.putString(
            SALES_ORDER_EDITING,
            if (salesOrder == null) "" else gson.toJson(salesOrder)
        ).commit()

        if (salesOrder == null) {
            setSalesOrderItemsListEditing(null)
        }
    }*/

    /*fun getSalesOrderEditing(): SalesOrder? {
        val value: String = prefs.getString(SALES_ORDER_EDITING, "")
        return if (value.isEmpty()) null else gson.fromJson(value, SalesOrder::class.java)
    }
*/

    /*fun setSalesOrderDividedItems(itemList: SalesOrderItemList?) {
        editor.putString(
            SALES_ORDER_DIVIDED_ITEMS,
            if (itemList == null) "" else gson.toJson(itemList)
        ).commit()
    }*/

    /*fun getSalesOrderDividedItems(): SalesOrderItemList? {
        val value: String? = prefs.getString(SALES_ORDER_DIVIDED_ITEMS, "")
        return if (value.isEmpty()) null else gson.fromJson(
            value,
            SalesOrderItemList::class.java
        )
    }*/


    //----------------------------------------//
//    fun setSaleToDuplicate(salesOrder: SalesOrder?) {
//        editor.putString(
//            DUPLICATE_SALE,
//            if (salesOrder == null) "" else gson.toJson(salesOrder)
//        ).commit()
//
//        if (salesOrder == null) {
//            setSaleItemsToDuplicate(null)
//        }
//    }

    /*fun getSaleToDuplicate(): SalesOrder? {
        val value: String = prefs.getString(DUPLICATE_SALE, "")
        return if (value.isEmpty()) null else gson.fromJson(value, SalesOrder::class.java)
    }
*/

    //----------------------------------------//
    /*fun setSalesOrderItemsListEditing(salesOrderItemList: SalesOrderItemList?) {
        editor.putString(
            SALES_ORDER_ITEMS_LIST_EDITING,
            if (salesOrderItemList == null) "" else gson.toJson(salesOrderItemList)
        ).commit()
    }*/

    /*fun getSalesOrderItemsListEditing(): SalesOrderItemList? {
        if (prefs != null) {
            val value: String? = prefs.getString(SALES_ORDER_ITEMS_LIST_EDITING, "")
            return if (value?.isEmpty() == true) null else gson.fromJson(
                value,
                SalesOrderItemList::class.java
            )
        } else {
            return null
        }
    }*/

    //todo implementar setSaleItemsToDuplicate
    /*fun setSaleItemsToDuplicate(salesOrderItemList: SalesOrderItemList?) {
        editor.putString(
            DUPLICATE_SALE_ITEMS,
            if (salesOrderItemList == null) "" else gson.toJson(salesOrderItemList)
        ).commit()
    }*/

    /*fun getSaleItemsToDuplicate(): SalesOrderItemList? {
        val value: String? = prefs.getString(DUPLICATE_SALE_ITEMS, "")
        return if (value?.isEmpty() == true) null else gson.fromJson(
            value,
            SalesOrderItemList::class.java
        )
    }*/

    //--------------------------------------------------//
    //todo implementar setFittingViewLookEditing
    /*fun setFittingViewLookEditing(lookCompoundList: LookCompoundItemList?) {
        editor.putString(FITTING_VIEW_EDITING_LOOK, gson.toJson(lookCompoundList))
            .commit()
    }*/

    /*fun getFittingViewLookEditing(): LookCompoundItemList {
        val value: String? = prefs.getString(FITTING_VIEW_EDITING_LOOK, "")
        return if (value?.isEmpty() == true) LookCompoundItemList() else gson.fromJson(
            value,
            LookCompoundItemList::class.java
        )
    }*/

    /*fun setSelectedModel(wearableModel: WearableModel?) {
        editor.putString(MODEL_SELECTED, gson.toJson(wearableModel)).commit()
    }
*/
    /*fun getSelectedModel(): WearableModel {
        val value: String? = prefs.getString(MODEL_SELECTED, "")
        return if (value?.isEmpty() == true) WearableModel() else gson.fromJson(
            value,
            WearableModel::class.java
        )
    }*/

    fun getLookCompoundSelectedId(): Int {
        return prefs.getInt(LOOK_COMPOUND_SELECTED, 0)
    }

    fun setLookCompoundSelectedId(value: Int) {
        editor.putInt(LOOK_COMPOUND_SELECTED, value).commit()
    }

    //todo implementar loadSyncCounter
    /*fun loadSyncCounter() {
        editor.putInt(
            SYNCING_HISTORY_COUNTER,
            SyncHistoryDAO(context).getLastCounter() + 1
        ).commit()
    }*/

    fun getSyncHistoryCounter(): Int {
        return prefs.getInt(SYNCING_HISTORY_COUNTER, 1)
    }

    fun getTitleSituationFilter(): Int {
        val result: Int = prefs.getInt(TITLES_SITUATION_FILTER, 0)
        setTitleSituationFilter(0)
        return result
    }

    fun setTitleSituationFilter(situation: Int) {
        putInt(TITLES_SITUATION_FILTER, situation)
    }

    fun getSalesOrderEmissionFilter(): String? {
        val result: String? = prefs.getString(SALES_ORDER_EMISSION_FILTER, "")
        setSalesOrderEmissionFilter("")
        return result
    }

    fun setSalesOrderEmissionFilter(emission: String?) {
        putString(SALES_ORDER_EMISSION_FILTER, emission!!)
    }

    fun getClientPositivationFilter(): Int {
        val result: Int = prefs.getInt(CLIENT_POSITIVATION_FILTER, 0)
        setClientPositivationFilter(0)
        return result
    }

    fun setClientPositivationFilter(positivation: Int) {
        putInt(CLIENT_POSITIVATION_FILTER, positivation)
    }

    fun getNotifyPositivationFilter(): Int {
        val result: Int = prefs.getInt(NOTIFY_POSITIVATION_FILTER, 0)
        setNotifyPositivationFilter(0)
        return result
    }

    fun setNotifyPositivationFilter(positivation: Int) {
        putInt(NOTIFY_POSITIVATION_FILTER, positivation)
    }

    fun setContactSelected(id: Int) {
        putInt(CLIENT_POSITIVATION_FILTER, id)
    }

    fun getContactSeleted(): Int {
        return getInt(CLIENT_POSITIVATION_FILTER)
    }

    fun setShowRepresentatives(s: Boolean) {
        putBoolean(SHOW_REPRESENTATIVES, s)
    }

    fun showRepresentatives(): Boolean {
        return prefs.getBoolean(SHOW_REPRESENTATIVES, false)
    }

    fun useFakeItem(): Int {
        return prefs.getInt(USE_FAKE_ITEM, 0)
    }

    fun setFakeItem(n: Int) {
        putInt(USE_FAKE_ITEM, n)
    }

    /*fun getCurrentIdPriceTable(): Int {
        return if (isAdding()) {
            if (getSalesOrderEditing() != null && getSalesOrderEditing().getIdPriceTable() > 0) {
                getSalesOrderEditing().getIdPriceTable()
            } else {
                0
            }
        } else {
            if (getSelectedPriceTable() != null && getSelectedPriceTable().getId() > 0) {
                getSelectedPriceTable().getId()
            } else {
                0
            }
        }
    }*/

    /*fun getPriceTableFromSale(): Int {
        return if (getSalesOrderEditing() != null) {
            getSalesOrderEditing().getIdPriceTable()
        } else {
            0
        }
    }*/

    //todo implementar setFreshCommision e getPriceTableFromSale
    /*fun setFreshCommision(commision: Commision?) {
        putString(FRESH_COMMISSION, gson.toJson(commision))
    }*/

    /*fun getFreshCommison(): Commision {
        return gson.fromJson(getString(FRESH_COMMISSION), Commision::class.java)
    }*/

    /*fun isCreatingASale(): Boolean {
        val s: SalesOrder? = getSalesOrderEditing()
        val l: SalesOrderItemList? = getSalesOrderItemsListEditing()
        if (l != null) for (i in 0..l.size() - 1) {
            System.out.println("TESTE VALOR DOS ITENS DO SHARED " + l.size())
        }

        return (s != null && l != null && !l.isEmpty() && (s.getId() === 0) && l.size() > 0)
    }*/

    fun getEan(): String? {
        val result: String? = prefs.getString(GETEAN, "")
        setEan(null)
        return result
    }

    fun setPassThroughNotDiscountField(pass: Boolean) {
        putBoolean(PASS_THROUGH_NOT_DISCOUNT_FIELD, pass)
    }

    fun getPassThroughNotDiscountField(): Boolean? {
        var result: Boolean? = null
        if (prefs != null) {
            result = prefs.getBoolean(PASS_THROUGH_NOT_DISCOUNT_FIELD, false)
            setPassThroughNotDiscountField(false)
        }
        return result
    }

    fun setEan(ean: String?) {
        putString(GETEAN, ean!!)
    }

    fun getEanByBarcode(): String {
        var result = ""
        if (prefs != null) {
            result = prefs.getString(GETEANBYBARCODE, "")!!
            setEanByBarcode(null)
        }
        return result
    }

    fun setEanByBarcode(ean: String?) {
        putString(GETEANBYBARCODE, ean!!)
    }

    fun setEanAutoClick(ean: String?) {
        putString(GETEANAUTO, ean!!)
    }

    fun getGetEanAuto(): String? {
        return prefs.getString(GETEANAUTO, "")
    }

    fun setClientContactEditing(idClient: Int) {
        putInt(CLIENT_CONTACT_EDITING, idClient)
    }

    fun getClientContactEditing(): Int {
        return getInt(CLIENT_CONTACT_EDITING, 0)
    }

    fun setPfilter(p: Int) {
        putInt(PARAMETER_SITUATION, p)
    }

    fun getPfilter(): Int {
        return getInt(PARAMETER_SITUATION, 0)
    }

    fun setIdFromPriceTable(p: Int) {
        putInt(ID_FROM_PRICE_TABLE, p)
    }

    fun getIdFromPriceTable(): Int {
        return getInt(ID_FROM_PRICE_TABLE, 0)
    }

    fun setPass(p: Int) {
        putInt(PASS, p)
    }

    fun getPass(): Int {
        return getInt(PASS, 0)
    }

    fun setPFilterSituation(pFilterSituation: Int) {
        putInt(PFILTERSITUATION, pFilterSituation)
    }

    fun getPFilterSituation(): Int {
        return getInt(PFILTERSITUATION, 0)
    }

    fun setSelectedProduct(idProduct: String?) {
        putString(SELECTED_PRODUCT, idProduct!!)
    }

    fun getSelectedProduct(): String? {
        return getString(SELECTED_PRODUCT, "")
    }

    fun alertToOpenSales(): Boolean {
        return getBoolean(ALERT_TO_OPEN_SALES, false)
    }

    fun setAlertToOpenSales(v: Boolean) {
        putBoolean(ALERT_TO_OPEN_SALES, v)
    }

    fun setvalidateStockOnFinish(v: Boolean) {
        putBoolean(VALIDATE_STOCK, v)
    }

    fun getValidateStock(): Boolean {
        return getBoolean(VALIDATE_STOCK, false)
    }

    fun getProductFromGrid(): Int {
        return getInt(PRODUCT_FROM_GRID, 0)
    }

    fun setProductFromGrid(id: Int) {
        putInt(PRODUCT_FROM_GRID, id)
    }

    fun setIdColorToFixedAsAlternativePacks(id: String?) {
        putString(ID_COLOR_TO_FIXED_AS_ALTERNATIVE_PACKS, id!!)
    }

    fun getIdColorToFixedAsAlternativePacks(): String? {
        return getString(ID_COLOR_TO_FIXED_AS_ALTERNATIVE_PACKS, "")
    }

    fun setSyncOnlyColor(t: Boolean) {
        putBoolean(SYNC_ONLY_COLORS, t)
    }

    fun getSyncOnlyColor(): Boolean {
        return getBoolean(SYNC_ONLY_COLORS, false)
    }

    fun setIdSalesOrderSituation(idPaymentCondition: String?) {
        putString(ID_SALES_TYPE, idPaymentCondition!!)
    }

    fun getIdSalesOrderSituation(): String? {
        return getString(ID_SALES_TYPE, "")
    }

    fun setNotPercentDiscount(percent: Float) {
        putFloat(DESC_FIELD_NOT_PERCENT, percent)
    }

    fun getNoPercentDiscount(): Float {
        return getFloat(DESC_FIELD_NOT_PERCENT, 0f)
    }

    fun getMultiPack(): Int {
        return getInt(MULTI_PACK, 1)
    }

    fun setMultiPack(id: Int) {
        putInt(MULTI_PACK, id)
    }

}

