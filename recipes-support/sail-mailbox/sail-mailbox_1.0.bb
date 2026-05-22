DESCRIPTION = "SAIL Mailbox userspace library and tools"
HOMEPAGE = "https://softwarecenter.qualcomm.com"

LICENSE = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://LICENSE.qcom-2;md5=165287851294f2fb8ac8cbc5e24b02b0"

SAILMB_BASE = "https://softwarecenter.qualcomm.com/nexus/generic/product/chip/software-product-family/Qualcomm_Linux.SPF.1.0/qualcomm_linux.spf.1.0-test-device-public"
SAILMB_PATH = "r1.0_00120.0/LE.QCLINUX.1.0.R1/apps_proc/prebuilt_HY22/sail-mailbox/260318"

SRC_URI = "${SAILMB_BASE}/${SAILMB_PATH}/sail-mailbox_${PV}_qcs9100.tar.gz"
SRC_URI[sha256sum] = "464adddd20b4466ccafbfdc0b7311ad98457c06fa0e11016b34150a709593847"

inherit bin_package

INSANE_SKIP:${PN} += "already-stripped"

# This package is only for ARMv8 (aarch64) machines.
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
