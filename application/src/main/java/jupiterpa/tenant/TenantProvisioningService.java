package jupiterpa.tenant;

public interface TenantProvisioningService {
    void subscribeTenant(String tenantId);

    void unsubscribeTenant(String tenantId);
}
