inherit bin_package

SUMMARY = "Driver providing support for SAIL-APSS Mailbox communication"
DESCRIPTION = "Provide Sail Mailbox Driver to communicate between SAIL and APSS"
LICENSE = "LICENSE.qcom-2"
LIC_FILES_CHKSUM = "file://LICENSE.qcom-2;md5=165287851294f2fb8ac8cbc5e24b02b0"
DEPENDS += "glib-2.0 systemd linux-libc-headers pkgconfig-native cmake-native"

# PBT variables — defined here since qcom-prebuilts.inc is not part of LE.QCLINUX.2.0
# In the reference project (meta-qcom-hwe) these come from conf/machine/include/qcom-prebuilts.inc
PBT_ARTIFACTORY ?= "https://softwarecenter.qualcomm.com/nexus/generic/product/chip/software-product-family/Qualcomm_Linux.SPF.1.0/qualcomm_linux.spf.1.0-test-device-public"
PBT_BUILD_ID    ?= "r1.0_00120.0"
PBT_BIN_PATH    ?= "LE.QCLINUX.1.0.R1/apps_proc/prebuilt_HY22/${BPN}/260318"
PBT_ARCH        ?= "qcs9100"
PBT_ARCH:qcs8300 = "qcs8300"

QCS9100_SHA256SUM = "464adddd20b4466ccafbfdc0b7311ad98457c06fa0e11016b34150a709593847"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI:append:qcs9100 = " ${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

QCS8300_SHA256SUM = "54cbc8a45793d5ff827f83cc9e04fb0caad48f4eb433ce1641f696b536e06701"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"
SRC_URI:append:qcs8300 = " ${PBT_ARTIFACTORY}/${PBT_BUILD_ID}/${PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

# Tarball unpacks directly to UNPACKDIR (no subdirectory)
S = "${UNPACKDIR}"

PACKAGES =+ "${PN}-bin"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN}-bin  = "${bindir}/sail_console_chan_app"
FILES:${PN}-bin += "${bindir}/saildbg"

INSANE_SKIP:${PN} += "already-stripped"
