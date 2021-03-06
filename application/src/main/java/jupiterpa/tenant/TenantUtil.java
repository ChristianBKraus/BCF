package jupiterpa.tenant;

public class TenantUtil {
    public static final String SCHEMA_PREFIX = "tenant_";
    public static final String DEFAULT_TENANT = "default-tenant";

    public static String createSchemaName(final String tenantId) {
        return tenantId.equals(DEFAULT_TENANT) ? DEFAULT_TENANT : SCHEMA_PREFIX + tenantId;
    }
}
