DESCRIPTION = "Qualcomm SAIL Mailbox Kernel Driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "e5044f27f4a42967561c09e0baff9f9c88dde101"
SRC_URI = " \
    git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/sail-mailbox-kmd.git;branch=sail-mailbox-kernel.lnx.1.0.r1-rel;protocol=https \
"

S = "${UNPACKDIR}/sail-mailbox-kmd"

inherit module

EXTRA_OEMAKE += "MACHINE='${MACHINE}'"
MAKE_TARGETS = "modules"
MODULES_INSTALL_TARGET = "modules_install"
KERNEL_MODULE_AUTOLOAD += "qcom-sail-mbox"

# This module is only supported on ARMv8 (aarch64) machines.
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
